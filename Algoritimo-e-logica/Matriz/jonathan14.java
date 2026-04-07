import java.util.Scanner;

public class jonathan14 {
    static int[] codigos = new int[50];
    static String[] nomes = new String[50];
    static int[] estoqueIdeal = new int[50];
    static int[] estoqueAtual = new int[50];
    static int totalPlantas = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("==========================================");
            System.out.println("FLORICULTURA MARIASFLOR");
            System.out.println("==========================================");
            System.out.println("1. CADASTRAR NOVA PLANTA");
            System.out.println("2. RETIRAR PLANTA");
            System.out.println("3. INSERIR PLANTA");
            System.out.println("4. IMPRIMIR RELATÓRIO");
            System.out.println("5. SAIR");
            System.out.println("==========================================");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                if (totalPlantas < 50) {
                    System.out.println("Código da planta:");
                    codigos[totalPlantas] = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome da planta:");
                    nomes[totalPlantas] = sc.nextLine();
                    System.out.println("Estoque ideal:");
                    estoqueIdeal[totalPlantas] = sc.nextInt();
                    System.out.println("Estoque atual:");
                    estoqueAtual[totalPlantas] = sc.nextInt();
                    totalPlantas++;
                    System.out.println("Planta cadastrada!");
                } else {
                    System.out.println("Limite de plantas atingido.");
                }
            } else if (opcao == 2) {
                System.out.println("Código da planta pra retirar:");
                int codigo = sc.nextInt();
                System.out.println("Quantidade pra retirar:");
                int qtd = sc.nextInt();
                boolean achou = false;

                for (int i = 0; i < totalPlantas; i++) {
                    if (codigos[i] == codigo) {
                        achou = true;
                        if (estoqueAtual[i] >= qtd) {
                            estoqueAtual[i] -= qtd;
                            System.out.println("Retirada feita!");
                        } else {
                            System.out.println("Não tem tudo isso em estoque.");
                        }
                    }
                }
                if (!achou) {
                    System.out.println("Planta não encontrada.");
                }
            } else if (opcao == 3) {
                System.out.println("Código da planta pra inserir:");
                int codigo = sc.nextInt();
                System.out.println("Quantidade comprada:");
                int qtd = sc.nextInt();
                boolean achou = false;

                for (int i = 0; i < totalPlantas; i++) {
                    if (codigos[i] == codigo) {
                        achou = true;
                        estoqueAtual[i] += qtd;
                        System.out.println("Estoque atualizado!");
                    }
                }
                if (!achou) {
                    System.out.println("Planta não encontrada.");
                }
            } else if (opcao == 4) {
                System.out.println("Relatório de plantas com estoque baixo:");
                for (int i = 0; i < totalPlantas; i++) {
                    if (estoqueAtual[i] < estoqueIdeal[i]) {
                        System.out.println("Nome: " + nomes[i]);
                        System.out.println("Estoque atual: " + estoqueAtual[i]);
                        System.out.println("Falta comprar: " + (estoqueIdeal[i] - estoqueAtual[i]));
                        System.out.println("-----------------------------");
                    }
                }
            } else if (opcao == 5) {
                System.out.println("Saindo... até mais!");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
