import java.util.Scanner;

public class jonathan10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você quer digitar? ");
        int n = sc.nextInt();

        if (n > 0) {
            int i = 0;
            double soma = 0;

            while (i < n) {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                double num = sc.nextDouble();
                soma += num;
                i++;
            }

            double media = soma / n;

            System.out.println("Soma dos números: " + soma);
            System.out.printf("Média dos números: %.2f%n", media);
        } else {
            System.out.println("Por favor, digite um valor positivo para N!");
        }

        sc.close();
    }
}
