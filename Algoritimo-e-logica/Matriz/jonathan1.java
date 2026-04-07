import java.util.Scanner;

public class jonathan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[2][2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite o %dº numero: ", i + 1);
                matriz[i][j] = sc.nextInt();
            }
        }
        op(matriz);
    }

    static void op(int matriz[][]) {

        int maior = Integer.MIN_VALUE;
        int primeiro = matriz[0][0];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (maior < matriz[i][j]) {
                    maior = matriz[i][j];
                }
            }
        }
        resultado(maior,primeiro);
    }

    static void resultado(int maior,int primeiro) {
        int resultante = maior * primeiro;

        System.out.println(resultante);
    }
}
