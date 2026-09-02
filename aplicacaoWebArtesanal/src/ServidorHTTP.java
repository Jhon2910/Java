

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PaginaDoArquivo extends Pagina {
    private String conteudo;

    public PaginaDoArquivo(String url) {
       
        String nomeArquivo = (url != null && url.startsWith("/")) ? url.substring(1) : url;

       
        String caminhoResource = "webapp/" + nomeArquivo;
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(caminhoResource)) {
            if (in != null) {
                this.conteudo = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                return;
            }
        } catch (Exception ignored) {}

       
        try {
            Path pathDisco = Paths.get("src", "webapp", nomeArquivo);
            if (Files.exists(pathDisco)) {
                this.conteudo = Files.readString(pathDisco, StandardCharsets.UTF_8);
                return;
            }
        } catch (Exception ignored) {}

        
        this.conteudo = null;
    }

    @Override
    public String getHtml() {
        return conteudo;
    }
}
