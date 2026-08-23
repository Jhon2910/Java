import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Receptor extends Pagina {
    private Requisicao req;

    public Receptor(Requisicao req) {
        this.req = req;
    }

    // Extrai os parâmetros da query string (GET)
    protected Map<String, String> getParametrosQuery() {
        if (req == null || req.getURL() == null) {
            return new LinkedHashMap<>();
        }

        String url = req.getURL();
        int posicaoInterrogacao = url.indexOf("?");

        if (posicaoInterrogacao != -1 && posicaoInterrogacao < url.length() - 1) {
            String queryString = url.substring(posicaoInterrogacao + 1);
            return extrairParametrosDeTexto(queryString);
        }

        return new LinkedHashMap<>();
    }

    // Extrai os parâmetros do corpo da requisição (POST)
    public Map<String, String> getParametrosPOST() {
        if (req == null || req.getCorpo() == null || req.getCorpo().isEmpty()) {
            return new LinkedHashMap<>();
        }

        return extrairParametrosDeTexto(req.getCorpo());
    }

    private Map<String, String> extrairParametrosDeTexto(String texto) {
        Map<String, String> parametros = new LinkedHashMap<>();
        String[] pares = texto.split("&");

        for (String par : pares) {
            String[] partes = par.split("=", 2);
            if (partes.length > 0 && !partes[0].isEmpty()) {
                String chave = URLDecoder.decode(partes[0], StandardCharsets.UTF_8);
                String valor = partes.length > 1 ? URLDecoder.decode(partes[1], StandardCharsets.UTF_8) : "";

                if (parametros.containsKey(chave)) {
                    parametros.put(chave, parametros.get(chave) + ", " + valor);
                } else {
                    parametros.put(chave, valor);
                }
            }
        }

        return parametros;
    }

    @Override
    public String getHtml() {
        Map<String, String> paramsGET = getParametrosQuery();
        Map<String, String> paramsPOST = getParametrosPOST();

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"pt-BR\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <title>Parâmetros Recebidos</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <h1>Parâmetros da Requisição</h1>\n");

        html.append("    <h2>Parâmetros GET (Query String)</h2>\n");
        if (paramsGET.isEmpty()) {
            html.append("    <p>Nenhum parâmetro GET recebido.</p>\n");
        } else {
            html.append("    <ul>\n");
            for (Map.Entry<String, String> par : paramsGET.entrySet()) {
                html.append("        <li><strong>")
                    .append(par.getKey())
                    .append(":</strong> ")
                    .append(par.getValue())
                    .append("</li>\n");
            }
            html.append("    </ul>\n");
        }

        html.append("    <h2>Parâmetros POST (Corpo)</h2>\n");
        if (paramsPOST.isEmpty()) {
            html.append("    <p>Nenhum parâmetro POST recebido.</p>\n");
        } else {
            html.append("    <ul>\n");
            for (Map.Entry<String, String> par : paramsPOST.entrySet()) {
                html.append("        <li><strong>")
                    .append(par.getKey())
                    .append(":</strong> ")
                    .append(par.getValue())
                    .append("</li>\n");
            }
            html.append("    </ul>\n");
        }

        html.append("</body>\n");
        html.append("</html>");

        return html.toString();
    }
}
