import java.util.Scanner;

public class jonathan13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] onibus = new int[2][24];
        String opcao;

        do {
            System.out.println("========================================");
            System.out.println(" MARIAS UNIDAS");
            System.out.println("========================================");
            System.out.println("a. Vender passagem");
            System.out.println("b. Mostrar mapa de ocupação do ônibus");
            System.out.println("c. Encerrar");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            opcao = sc.next();

            if (opcao.equalsIgnoreCase("a")) {
                int lugaresDisponiveis = 0;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 24; j++) {
                        if (onibus[i][j] == 0) {
                            lugaresDisponiveis++;
                        }
                    }
                }

                if (lugaresDisponiveis == 0) {
                    System.out.println("Ônibus lotado. Venda não pode ser realizada.");
                } else {
                    System.out.print("Janela (J) ou Corredor (C)? ");
                    String tipoAssento = sc.next();
                    System.out.print("Qual poltrona (1-24)? ");
                    int numPoltrona = sc.nextInt();

                    int tipo = -1;
                    if (tipoAssento.equalsIgnoreCase("J")) {
                        tipo = 0;
                    } else if (tipoAssento.equalsIgnoreCase("C")) {
                        tipo = 1;
                    }

                    if (tipo == -1 || numPoltrona < 1 || numPoltrona > 24) {
                        System.out.println("Opção inválida.");
                    } else if (onibus[tipo][numPoltrona - 1] == 0) {
                        onibus[tipo][numPoltrona - 1] = 1;
                        System.out.println("Venda efetivada.");
                    } else {
                        System.out.println("Poltrona ocupada.");
                    }
                }
            } else if (opcao.equalsIgnoreCase("b")) {
                System.out.println("\n--- MAPA DE OCUPAÇÃO ---");
                System.out.println("Poltronas da Janela:");
                for (int i = 0; i < 24; i++) {
                    String status = (onibus[0][i] == 0) ? "Livre" : "Ocupada";
                    System.out.println("Poltrona " + (i + 1) + ": " + status);
                }

                System.out.println("\nPoltronas do Corredor:");
                for (int i = 0; i < 24; i++) {
                    String status = (onibus[1][i] == 0) ? "Livre" : "Ocupada";
                    System.out.println("Poltrona " + (i + 1) + ": " + status);
                }
            } else if (!opcao.equalsIgnoreCase("c")) {
                System.out.println("Opção inválida.");
            }
            System.out.println();

        } while (!opcao.equalsIgnoreCase("c"));

        System.out.println("Programa encerrado.");
        sc.close();
    }
}
