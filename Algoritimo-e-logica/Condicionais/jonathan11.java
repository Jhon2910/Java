import java.util.Scanner;

public class jonathan11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor do diametro: ");
        if (sc.hasNextDouble()) {
            double D = sc.nextDouble();

            System.out.print("Digite o valor carga: ");
            if (sc.hasNextDouble()) {
                double Q = sc.nextDouble();

                double N;

                if (D < 50) {
                    N = 6;
                }
                else if (D <= 100) {
                    N = 4;
                }
                else {
                    N = 2;
                }

                double S = ((4 * Q) / (Math.PI * Math.pow(D, 2))) * N;
                System.out.printf("O resultado é: %.2f%n", S);

            }
            else {
                System.out.print("Digite apenas números!");
            }
        }
        else {
            System.out.print("Digite apenas números!");
        }
        sc.close();
    }
}
