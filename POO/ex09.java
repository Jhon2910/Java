import java.util.Scanner;

public class ex09 {
    static Scanner sc = new Scanner(System.in);
    public static long fat(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    public static long permutacoes(int n) {
        return fat(n);
    }
    public static long arranjos(int n, int k) {
        if (n < k || n < 0 || k < 0) {
            System.out.println("Erro: Para Arranjos e Combinações, n deve ser maior ou igual a k, e ambos não negativos.");
            return 0;
        }
        return fat(n) / fat(n - k);
    }
    public static long combinacoes(int n, int k) {
        if (n < k || n < 0 || k < 0) {
            System.out.println("Erro: Para Arranjos e Combinações, n deve ser maior ou igual a k, e ambos não negativos.");
            return 0;
        }
        return fat(n) / (fat(k) * fat(n - k));
    }

    public static void main(String[] args) {

        System.out.print("Digite o valor de n: ");
        int n = sc.nextInt();

        System.out.print("Digite o valor de k: ");
        int k = sc.nextInt();

        sc.close();

        System.out.println("\n-- Resultados --");

        long resultadoP = permutacoes(n);
        System.out.println("1. Permutações de n elementos (P" + n + " = " + n + "!): " + resultadoP);

        long resultadoA = arranjos(n, k);
        System.out.println("2. Arranjos de " + n + " tomados " + k + " a " + k + " (A" + n + "," + k + "): " + resultadoA);
        
        long resultadoC = combinacoes(n, k);
        System.out.println("3. Combinações de " + n + " tomados " + k + " a " + k + " (C" + n + "," + k + "): " + resultadoC);
    }
}
