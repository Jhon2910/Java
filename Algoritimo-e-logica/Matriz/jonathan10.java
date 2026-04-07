import java.util.Arrays;

public class jonathan10 {

    private int[][] L;
    private int n;

    public jonathan10(int[][] matriz) {
        L = matriz;
        n = matriz.length;
    }

    public void analisarCidade(int k) {
        int estradasSaem = 0;
        int estradasChegam = 0;

        for (int j = 0; j < n; j++) {
            if (L[k][j] == 1) {
                estradasSaem++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (L[i][k] == 1) {
                estradasChegam++;
            }
        }

        System.out.println("Análise da cidade " + k + ":");
        System.out.println("  Número de estradas que saem: " + estradasSaem);
        System.out.println("  Número de estradas que chegam: " + estradasChegam);
    }

    public void MaisChegadas() {
        int maxChegadas = -1;
        String cidadesComMaisChegadas = "";

        for (int j = 0; j < n; j++) {
            int chegadas = 0;
            for (int i = 0; i < n; i++) {
                if (L[i][j] == 1) {
                    chegadas++;
                }
            }

            if (chegadas > maxChegadas) {
                maxChegadas = chegadas;
                cidadesComMaisChegadas = String.valueOf(j);
            } else if (chegadas == maxChegadas) {
                cidadesComMaisChegadas += ", " + j;
            }
        }

        System.out.println("Cidades com o maior número de estradas chegando (" + maxChegadas + " estradas): " + cidadesComMaisChegadas);
    }

    public void CidadesIsoladas() {
        boolean encontrouIsolada = false;
        System.out.println("Cidades isoladas:");

        for (int i = 0; i < n; i++) {
            boolean ehIsolada = true;

            for (int j = 0; j < n; j++) {
                if (L[i][j] == 1) {
                    ehIsolada = false;
                    break;
                }
            }
            if (ehIsolada) {
                for (int j = 0; j < n; j++) {
                    if (L[j][i] == 1) {
                        ehIsolada = false;
                        break;
                    }
                }
            }

            if (ehIsolada) {
                System.out.println("  - Cidade " + i);
                encontrouIsolada = true;
            }
        }

        if (!encontrouIsolada) {
            System.out.println("  Não há cidades isoladas.");
        }
    }

    public void verificarRota(int[] rota) {
        boolean rotaEhPossivel = true;

        System.out.println("Verificando a rota: " + Arrays.toString(rota));

        for (int i = 0; i < rota.length - 1; i++) {
            int cidadeOrigem = rota[i];
            int cidadeDestino = rota[i + 1];

            if (L[cidadeOrigem][cidadeDestino] == 0) {
                rotaEhPossivel = false;
                break;
            }
        }

        if (rotaEhPossivel) {
            System.out.println("  A rota é possível!");
        } else {
            System.out.println("  A rota não é possível.");
        }
    }
}
