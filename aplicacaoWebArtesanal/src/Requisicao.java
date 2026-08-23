public class Requisicao {
    private String documentoBruto;
    private String metodo;
    private String url;
    private String corpo = "";

    public Requisicao(String documentoBruto) {
        this.documentoBruto = documentoBruto;

        if (documentoBruto == null || documentoBruto.isEmpty()) {
            return;
        }

        // Separa os cabeçalhos do corpo pelo "\r\n\r\n"
        String[] partes = documentoBruto.split("\r\n\r\n", 2);
        if (partes.length > 1) {
            this.corpo = partes[1];
        }

        // A primeira linha contém: METODO URL PROTOCOLO
        String cabecalhos = partes[0];
        String[] linhas = cabecalhos.split("\r\n");
        if (linhas.length > 0) {
            String[] partesLinha = linhas[0].split(" ");
            if (partesLinha.length > 0) {
                this.metodo = partesLinha[0];
            }
            if (partesLinha.length > 1) {
                this.url = partesLinha[1];
            }
        }
    }

    public String getMetodo() {
        return metodo;
    }

    public String getURL() {
        return url;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getDocumentoBruto() {
        return documentoBruto;
    }
}
