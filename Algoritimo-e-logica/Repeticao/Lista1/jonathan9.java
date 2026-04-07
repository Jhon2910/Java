import java.util.Scanner;

public class jonathan9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você quer digitar? ");
        int n = sc.nextInt();

        if (n > 0) {
            int i = 0;
            double soma = 0;

            while (i < n) {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                double numero = sc.nextDouble();
                soma += numero;
                i++;
            }

            double media = soma / n;

            System.out.println("Soma = " + soma);
            System.out.printf("Média = %.2f%n", media);
        } else {
            System.out.println("Por favor, digite um número positivo!");
        }

        sc.close();
    }
}
