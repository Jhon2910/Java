import java.util.Scanner;

public class jonathan12 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 0;
        perguntas(n);
    }

    public static void perguntas(int n) {
        System.out.print("Quantos números gostaria de digitar? ");
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, digite um número inteiro.");
            System.out.print("Quantos números gostaria de digitar? ");
            sc.next();
        }
        n = sc.nextInt();

        int[] vet = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro.");
                System.out.printf("Digite o %dº número: ", i + 1);
                sc.next();
            }
            vet[i] = sc.nextInt();
        }

        verificar(vet);
    }

    public static void verificar(int[] vet) {
        boolean crescente = true;

        for (int i = 0; i < vet.length - 1; i++) {
            if (vet[i] > vet[i + 1]) {
                crescente = false;
                break;
            }
        }

        if (crescente) {
            System.out.println("Os números digitados estão em ordem crescente.");
        } else {
            System.out.println("Os números digitados NÃO estão em ordem crescente.");
        }
    }
}
