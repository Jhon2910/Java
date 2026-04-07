import java.util.Random;
import java.util.Scanner;

public class jonathan9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();
        int linhas;
        int col;

        System.out.println("Digiter as linhas da matriz: ");
        while (!sc.hasNextInt()) {
            System.out.println("Digite apenas numeros inteiros.");
            System.out.println("Digiter as linhas da matriz: ");
            sc.next();
        }
        linhas = sc.nextInt();

        System.out.println("Digite as colunas da matriz: ");
        while (!sc.hasNextInt()) {
            System.out.println("Digite apenas numeros inteiros.");
            System.out.println("Digiter as colunas da matriz: ");
            sc.next();
        }
        col = sc.nextInt();

        int matriz[][] = new int[linhas][col];
        int somaLinha[] = new int[matriz.length];
        int somaColuna[] = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(0, 2);
                somaColuna[i] += matriz[i][j];
                somaLinha[i] += matriz[i][j];
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            if (somaColuna[i] > 1 || somaLinha[i] > 1) {
                System.out.println("N");
                return;
            }
        }

        System.out.println("S");

    }
}
