import java.util.Scanner;

public class jonathan8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double matriz[][] = new double[8][8];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite o %d numero da %d matriz: ", (j + 1), (i + 1));
                matriz[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != matriz[j][i]){
                    System.out.println("nao e simetrica");
                    return;
                }
            }
        }

        System.out.println("e simetrica");

    }
}
