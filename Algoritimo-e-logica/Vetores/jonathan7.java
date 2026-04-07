import java.util.Scanner;

public class jonathan7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("Digite quantos números gostaria de digitar (até 100): ");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Digite apenas números inteiros! ");
                sc.next();
            }
            n = sc.nextInt();
            if (n > 0 && n <= 100) {
                break;
            } else {
                System.out.print("Digite um valor entre 1 e 100: ");
            }
        }

        int[] vetor1 = new int[n];
        int[] vetor2 = new int[n];
        int cont1 = 0, cont2 = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.print("Digite apenas números inteiros! ");
                sc.next();
            }
            int num = sc.nextInt();

            if (num > 0 && num % 2 == 0) {
                vetor1[cont1++] = num;
            } else if (num % 2 != 0 || num < 0) {
                vetor2[cont2++] = num;
            }
        }

        System.out.print("Vetor1 (positivos e pares): ");
        for (int i = 0; i < cont1; i++) {
            System.out.print(vetor1[i] + " ");
        }
        System.out.println();

        System.out.print("Vetor2 (ímpares e/ou negativos): ");
        for (int i = 0; i < cont2; i++) {
            System.out.print(vetor2[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
