import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PaginaDoArquivo extends Pagina {
    private String url;

    public PaginaDoArquivo(String url) {
        this.url = url;
    }

    @Override
    public String getHtml() {
        if (url == null || url.trim().isEmpty()) {
            return null;
        }

        try {
            // Se for "/", direciona para /index.html
            String urlTratada = url.equals("/") ? "/index.html" : url;
            String nomeArquivo = urlTratada.startsWith("/") ? urlTratada.substring(1) : urlTratada;

            // 1. Tenta carregar do pacote webapp (classpath)
            InputStream is = getClass().getResourceAsStream("/webapp/" + nomeArquivo);
            if (is != null) {
                return new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }

            // 2. Se não achar no classpath, lê direto da pasta src/webapp
            Path caminho = Path.of("src/webapp", nomeArquivo);
            if (Files.exists(caminho)) {
                return Files.readString(caminho, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
