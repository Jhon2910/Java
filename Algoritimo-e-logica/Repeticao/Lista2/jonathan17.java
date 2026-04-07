import java.util.Scanner;

public class jonathan17{
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        double n1, n2;
        double soma=0,div=0,mult=0,sub=0;
        int opcao, i = 0;

        while (i < Integer.MAX_VALUE) {

            System.out.println("\n--------------------------------------------");
            System.out.println("--------------------------------------------");
            System.out.print("          Calculadora de Jonathan");
            System.out.println("\n--------------------------------------------");
            System.out.println("--------------------------------------------");

            System.out.println("Opções:");
            System.out.println("        1 -Soma");
            System.out.println("        2 -Subtração");
            System.out.println("        3 -Multiplicação");
            System.out.println("        4 -Divisão");
            System.out.println("        5 -Sair");

            System.out.println("\n--------------------------------------------");
            System.out.println("--------------------------------------------");

            System.out.print("\nDigite a Opçao: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Opcao invalida!");
                sc.next();
            }
            opcao = sc.nextInt();

            while (opcao < 1 || opcao > 5) {
                System.out.print("Digite valores entre 1 e 5!");
                System.out.print("\nDigite a Opçao: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Opcao invalida!");
                    System.out.print("Digite valores entre 1 e 5!");
                    System.out.print("\nDigite a Opçao: ");
                    sc.next();
                }
                opcao = sc.nextInt();
            }

            System.out.print("Digite o 1 numero: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Digite apenas numeros validos!");
                System.out.print("Digite o 1 numero: ");
                sc.next();
            }
            n1 = sc.nextInt();

            System.out.print("Digite o 2 numero: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Digite apenas numeros validos!");
                System.out.print("Digite o 2 numero: ");
            }
                n2 = sc.nextInt();

                if (opcao == 1) {
                    soma = n1 + n2;
                    System.out.printf("%.2f + %.2f = %.2f",n1,n2,soma);
                } else if (opcao == 2) {
                    sub = n1 - n2;
                    System.out.printf("%.2f - %.2f = %.2f",n1,n2,sub);
                } else if (opcao == 3) {
                    mult = n1 * n2;
                    System.out.printf("%.2f * %.2f = %.2f",n1,n2,mult);
                } else if (opcao == 4) {
                    div = n1 / n2;
                    System.out.printf("%.2f / %.2f = %.2f",n1,n2,div);
                } else {
                    return;
                }
            i++;
            }
        sc.close();
        }


    }
