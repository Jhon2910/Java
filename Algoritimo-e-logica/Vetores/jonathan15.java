import java.util.Scanner;

public class jonathan15 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int contas[] = {501, 502, 503, 504, 505, 506, 507, 508, 509, 510};
        double saldo[] = new double[contas.length];
        int codigo;
        boolean encontrado = true;

        for (int i = 0; i < contas.length; i++) {
            saldo[i] = 0;
        }

        while (encontrado) {
            System.out.print("\nDigite o codigo da conta: ");
            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número inteiro para o código da conta: ");
                System.out.print("\nDigite o codigo da conta: ");
                sc.next();
            }
            codigo = sc.nextInt();

            for (int i = 0; i < contas.length; i++) {
                if (contas[i] == codigo) {
                    System.out.println("\nBem vindo, " + codigo);
                    int posicaoConta = i;
                    operacoes(contas, saldo, posicaoConta);
                    encontrado = false;
                    break;
                } else if (i == contas.length - 1) {
                    System.out.println("Conta não encontrada.");
                }
            }
        }
        sc.close();
    }

    public static void menu() {
        System.out.println("\n------------------MENU DE OPERAÇÕES------------------\n");
        System.out.println("1 - Efetuar depósito");
        System.out.println("2 - Efetuar saque");
        System.out.println("3 - Consultar saldo em conta");
        System.out.println("4 - finalizar o programa");
    }

    public static void operacoes(int contas[], double saldo[], int numeroConta) {

        int opcoes;
        double deposito, saque;
        boolean finalizar = true;

        while (finalizar) {

            menu();

            System.out.print("\nDigite a opção desejada: ");
            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número inteiro para a opção: ");
                System.out.print("Digite a opção desejada: ");
                sc.next();
            }
            opcoes = sc.nextInt();

            if (opcoes < 0 || opcoes > 4) {
                System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 4.");
            } else if (opcoes == 1) {
                System.out.println("Qunto deseja depositar? ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Entrada inválida. Digite um número válido para o depósito: ");
                    System.out.print("Quanto deseja depositar? ");
                    sc.next();
                }
                deposito = sc.nextDouble();

                if (deposito < 1) {
                    System.out.println("Digite um valor positivo para o depósito.");
                } else {
                    saldo[numeroConta] += deposito;
                }

            } else if (opcoes == 2) {
                System.out.println("Quanto deseja sacar?");
                while (!sc.hasNextDouble()) {
                    System.out.println("Entrada inválida. Digite um número válido para o saque.");
                    System.out.print("Quanto deseja sacar? ");
                    sc.next();
                }
                saque = sc.nextDouble();

                if (saldo[numeroConta] < saque) {
                    System.out.println("Saldo insuficiente!");
                } else {
                    saldo[numeroConta] -= saque;
                }

            } else if (opcoes == 3) {
                for (int i = 0; i <= numeroConta; i++) {
                    System.out.printf("\nSeu saldo é: %.2f ", saldo[numeroConta]);
                }
            } else {
                System.out.println("Finalizando o programa.");
                finalizar = false;

            }
        }
    }
}
