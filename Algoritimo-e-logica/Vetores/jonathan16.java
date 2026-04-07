import java.util.Scanner;

public class jonathan16 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Digite o tamanho da sequência: ");
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            System.out.print("\nDigite o tamanho da sequência: ");
            sc.next();
        }
        int N = sc.nextInt();

        System.out.println(" ");

        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Digite o %d numero: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                System.out.printf("\nDigite o %d numero: ", i + 1);
                sc.next();
            }
            A[i] = sc.nextInt();
        }
        saida(N, A);
    }

    public static void saida(int N, int A[]) {
        String resultado = "N";

        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] > A[i] && A[i] < A[i + 1]) {
                resultado = "S";
                break;
            }
            System.out.printf("resultado:  %s ", resultado);
        }
    }
}
