import java.util.Scanner;

public class jonathan13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int finalizar;

        while (true) {
            System.out.print("Para finalizar digite 0 ou qualquer outro numero para continuar: ");
            while (!sc.hasNextInt()) {
                System.out.println("Digite apenas numeros inteiros!");
                System.out.print("Para finalizar digite 0 ou qualquer outro numero para continuar: ");
                sc.next();
            }
            finalizar = sc.nextInt();

            if (finalizar == 0) {
                System.out.println("Finalizando!");
                return;
            }

                System.out.print("\nDigite um número para saber se é primo ou não: ");
                while (!sc.hasNextInt()) {
                    System.out.print("\nErro! Você não digitou um número válido! Tente novamente.");
                    System.out.print("\nDigite um número para saber se é primo ou não: ");
                    sc.next();
                }

                n = sc.nextInt();
                sc.nextLine();

                if (n <= 1) {
                    System.out.printf("O número %d não é primo.\n", n);
                } else {
                    boolean primo = true;

                    for (int j = 2; j <= Math.sqrt(n); j++) {
                        if (n % j == 0) {
                            primo = false;
                            break;
                        }
                    }
                    if (primo) {
                        System.out.printf("O número %d é primo.\n", n);
                    } else {
                        System.out.printf("O número %d não é primo.\n", n);
                    }
                }sc.close();
            }
        }
    }
