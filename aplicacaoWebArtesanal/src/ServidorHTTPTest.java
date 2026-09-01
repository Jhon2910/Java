import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ServidorHTTPTest {

    public static void main(String[] args) {
        testLerRequisicaoPOSTComCorpo();
        testReceptorComPOST();
        System.out.println("\n>>> TODOS OS TESTES PASSARAM COM SUCESSO! <<<");
    }

    public static void testLerRequisicaoPOSTComCorpo() {
        System.out.println("Executando: testLerRequisicaoPOSTComCorpo...");

        String corpoEsperado = "titulo=Engenharia+de+Software&ano=2024&autor=Pressman";
        int tamanhoCorpo = corpoEsperado.getBytes(StandardCharsets.UTF_8).length;

        String documentoRequisicao =
                "POST /receptor HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "User-Agent: Mozilla/5.0\r\n" +
                "Content-Type: application/x-www-form-urlencoded\r\n" +
                "Content-Length: " + tamanhoCorpo + "\r\n" +
                "\r\n" +
                corpoEsperado;

        InputStream entrada = new ByteArrayInputStream(documentoRequisicao.getBytes(StandardCharsets.UTF_8));
        ServidorHTTP servidor = new ServidorHTTP();

        try {
            Requisicao req = servidor.lerRequisicao(entrada);

            assert req != null : "Erro: Requisição não deveria ser nula";
            assert "POST".equals(req.getMetodo()) : "Erro no método: " + req.getMetodo();
            assert "/receptor".equals(req.getURL()) : "Erro na URL: " + req.getURL();
            assert corpoEsperado.equals(req.getCorpo()) : "Erro no corpo: " + req.getCorpo();

            System.out.println("  [OK] Método: " + req.getMetodo());
            System.out.println("  [OK] URL: " + req.getURL());
            System.out.println("  [OK] Corpo: " + req.getCorpo());
        } catch (Exception e) {
            throw new RuntimeException("Falha no teste: " + e.getMessage(), e);
        }
    }

    public static void testReceptorComPOST() {
        System.out.println("\nExecutando: testReceptorComPOST...");

        String doc = "POST /receptor HTTP/1.1\r\nContent-Length: 29\r\n\r\nnome=Carlos+Silva&idade=30";
        Requisicao req = new Requisicao(doc);
        Receptor receptor = new Receptor(req);

        Map<String, String> paramsPOST = receptor.getParametrosPOST();

        assert "Carlos Silva".equals(paramsPOST.get("nome")) : "Erro no parâmetro 'nome'";
        assert "30".equals(paramsPOST.get("idade")) : "Erro no parâmetro 'idade'";

        System.out.println("  [OK] Parâmetro 'nome': " + paramsPOST.get("nome"));
        System.out.println("  [OK] Parâmetro 'idade': " + paramsPOST.get("idade"));
    }
}
