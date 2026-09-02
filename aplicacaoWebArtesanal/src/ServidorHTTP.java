import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServidorHTTP {

    protected Requisicao lerRequisicao(InputStream in) throws IOException {
        BufferedReader leitorLinhas = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String linha;
        int contentLength = 0;

        while ((linha = leitorLinhas.readLine()) != null && !linha.isBlank()) {
            sb.append(linha).append("\r\n");

            if (linha.toLowerCase().startsWith("content-length:")) {
                try {
                    contentLength = Integer.parseInt(linha.substring("content-length:".length()).trim());
                } catch (NumberFormatException e) {
                    contentLength = 0;
                }
            }
        }

        String documentoCabecalhos = sb.toString();
        if (documentoCabecalhos.isEmpty()) {
            return null;
        }

        if (documentoCabecalhos.startsWith("GET") || contentLength == 0) {
            return new Requisicao(documentoCabecalhos);
        }

        sb.append("\r\n");
        char[] buffer = new char[contentLength];
        int lidos = 0;
        while (lidos < contentLength) {
            int r = leitorLinhas.read(buffer, lidos, contentLength - lidos);
            if (r == -1) break;
            lidos += r;
        }
        sb.append(buffer, 0, lidos);

        return new Requisicao(sb.toString());
    }

    protected Pagina getPagina(Requisicao req) {
        if (req == null || req.getURL() == null) {
            return null;
        }

        String url = req.getURL();

        if ("/".equals(url)) {
            url = "/index.html";
        }

        if (url.startsWith("/receptor")) {
            return new Receptor(req);
        }

        PaginaDoArquivo pagina = new PaginaDoArquivo(url);
        if (pagina.getHtml() != null) {
            return pagina;
        }

        return null;
    }

    protected Resposta criarResposta(Pagina pagina) {
        Resposta res = new Resposta();

        if (pagina == null) {
            res.setStatus(404, "Not Found");
            res.setBody("<h1>404 Not Found</h1>");
            return res;
        }

        res.setStatus(200, "OK");
        res.setBody(pagina.getHtml());
        return res;
    }

    protected void enviarResposta(Resposta res, OutputStream out) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8), true);
        writer.print(res.getDocumentoBruto());
        writer.flush();
    }

    public void iniciar(int porta) {
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor ouvindo na porta " + porta);
            System.out.printf("Acesse esta aplicação pelo endereço %s:%d\n", "http://localhost", porta);
            System.out.println("Para parar o servidor, aperte Ctrl-C.");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {

                    Requisicao req = lerRequisicao(in);
                    Pagina pag = getPagina(req);
                    Resposta res = criarResposta(pag);
                    enviarResposta(res, out);

                } catch (IOException e) {
                    System.err.println("Erro no processamento da requisição: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro no ServerSocket: " + e.getMessage());
        }
    }
}
