import java.util.Scanner;

public class jonathan7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = sc.nextInt();

        if (n >= 1) {
            int i = 1;
            double h = 0.0;

            System.out.print("H = ");
            while (i <= n) {
                h += 1.0 / i;

                if (i == 1) {
                    System.out.print("1");
                } else {
                    System.out.print(" + 1/" + i);
                }

                i++;
            }
            System.out.printf("%nSoma da série harmônica até 1/%d é: %.4f%n", n, h);
        }
        else{
            System.out.println("Por favor, digite um número positivo!");
        }
        sc.close();
    }
}
