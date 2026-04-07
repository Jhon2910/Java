import java.util.Scanner;

public class jonathan8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = sc.nextInt();

        if (n >= 1) {
            int i = 1;
            double h = 0.0;

            System.out.print("H = ");
            while (i <= n) {
                if (i % 2 == 0) {
                    h -= 1.0 / i;
                    System.out.print(" - 1/" + i);
                } else {
                    if (i == 1) {
                        System.out.print("1");
                    } else {
                        System.out.print(" + 1/" + i);
                    }
                    h += 1.0 / i;
                }

                i++;
            }

            System.out.printf("%nSoma da série alternada até 1/%d é: %.4f%n", n, h);
        } else {
            System.out.println("Por favor, digite um número positivo!");
        }

        sc.close();
    }
}
