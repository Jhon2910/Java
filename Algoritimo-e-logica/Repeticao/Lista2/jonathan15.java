import java.util.Scanner;

public class jonathan15{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int n, posicao;

        while (i < Integer.MAX_VALUE) {
            System.out.print("\nDigite um valor para saber para saber qual e ele na serie de Fibonacci: ");
            while (!sc.hasNextInt()) {
                System.out.print("\nValor invalido, tente novamente!");
                System.out.print("\nDigite um valor para saber para saber qual e ele na serie de Fibonacci: ");
                sc.next();
            }
            n = sc.nextInt();

            if (n < 0) {
                System.out.print("\nValor invalido, tente novamente!");
            } else if (n == 0) {
                System.out.printf("O %dº numero da serie de Fibonacci é : 0", n);
            } else if (n == 1) {
                System.out.printf("O %dº numero da serie de Fibonacci é : 1", n);
            } else {
                int a = 0;
                int b = 1;
                int fibonacci = 0;
                posicao = 2;

                while (posicao <= n) {
                    fibonacci = a + b;
                    a = b;
                    b = fibonacci;
                    posicao++;
                }
                i++;
            }
            sc.close();
        }
    }
}
