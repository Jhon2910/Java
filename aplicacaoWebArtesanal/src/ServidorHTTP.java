import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServidorHTTP {

    // Método que lê a requisição do fluxo de entrada (suportando GET e POST com Content-Length)
    protected Requisicao lerRequisicao(InputStream in) throws IOException {
        BufferedReader leitorLinhas = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String linha;
        int contentLength = 0;

        // Lê a linha de requisição e os cabeçalhos até a linha em branco
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

        // Adiciona a linha em branco que separa os cabeçalhos do corpo
        sb.append("\r\n");

        // Se houver corpo informado pelo Content-Length, lê exatamente os bytes do corpo
        if (contentLength > 0) {
            char[] buffer = new char[contentLength];
            int lidos = 0;
            while (lidos < contentLength) {
                int r = leitorLinhas.read(buffer, lidos, contentLength - lidos);
                if (r == -1) break;
                lidos += r;
            }
            sb.append(buffer, 0, lidos);
        }

        return new Requisicao(sb.toString());
    }

    // Retorna o objeto Pagina adequado para a URL da requisição
    protected Pagina getPagina(Requisicao req) {
        if (req == null || req.getURL() == null) {
            return null;
        }

        String url = req.getURL();

        // Rota padrão "/"
        if ("/".equals(url)) {
            url = "/index.html";
        }

        // Se a requisição for para /receptor, delega para Receptor
        if (url.startsWith("/receptor")) {
            return new Receptor(req);
        }

        // Busca o arquivo correspondente
        PaginaDoArquivo pagina = new PaginaDoArquivo(url);
        if (pagina.getHtml() != null) {
            return pagina;
        }

        // Retorna null para páginas que não existem (gerando o 404)
        return null;
    }

    // Cria o documento de resposta HTTP a partir do objeto Pagina
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

    // Envia o documento de resposta para o fluxo de saída do socket
    protected void enviarResposta(Resposta res, OutputStream out) throws IOException {
        PrintWriter writer = new PrintWriter(out, true);
        writer.print(res.getDocumentoBruto());
    }

    // Método principal que inicia o servidor na porta especificada
    public void iniciar(int porta) {
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor ouvindo na porta " + porta);
            System.out.printf("Acesse esta aplicação pelo endereço %s:%d\n",
                    "http://localhost", porta);
            System.out.println("Para parar o servidor, aperte Ctrl-C.");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {

                    Requisicao req = lerRequisicao(in);
                    Pagina pag = getPagina(req);
                    Resposta res = criarResposta(pag);
                    enviarResposta(res, out);
                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
