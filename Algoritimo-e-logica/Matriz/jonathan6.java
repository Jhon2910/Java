import java.util.Random;
import java.util.Scanner;

public class jonathan9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();

        int matriz[][] = new int[4][7];
        int menor = Integer.MAX_VALUE;
        int menorLinha = 0;
        int MINMAX = Integer.MIN_VALUE;
        int colMINMAX = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(0, 22);
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    menorLinha = i;
                }
                System.out.println(matriz[i][j]);
            }
            System.out.println(" ");
        }

        System.out.println(" ");

        for (int j = 0; j < 7; j++) {
            if (MINMAX < matriz[menorLinha][j]) {
                MINMAX = matriz[menorLinha][j];
                colMINMAX = j;
            }
        }
        System.out.println(MINMAX);
        System.out.println(menorLinha);
        System.out.println(colMINMAX);

    }
}
