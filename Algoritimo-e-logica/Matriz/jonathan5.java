import java.util.Scanner;
import java.util.Random;

public class jonathan5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();

        int latasPorlinha;
        int linhas = 6;
        int SomaDasLinhas[] = {0, 0, 0, 0, 0, 0};
        double media[] = new double[linhas];

        System.out.print("\nDigite a quantidade de latas por linha: ");
        while (!sc.hasNextInt()) {
            System.out.print("Digite apenas numeros inteiros.");
            System.out.print("\nDigite a quantidade de latas por linha: ");
            sc.next();
        }
        latasPorlinha = sc.nextInt();

        int matriz[][] = new int[linhas][latasPorlinha];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(350, 400);
                SomaDasLinhas[i] += matriz[i][j];
                media[i] = (double) SomaDasLinhas[i] / latasPorlinha;
            }
        }

        double resultado[] = new double[linhas];

        for (int i = 0; i < matriz.length; i++) {
            resultado[i] = Math.pow(SomaDasLinhas[i] - media[i], 2) / latasPorlinha - 1;
        }
        double desvioPadrao[] = new double[linhas];

        for (int i = 0; i < linhas; i++) {
            desvioPadrao[i] = Math.sqrt(resultado[i]);
            System.out.println("media " + media[i]);
            System.out.println("desvio " + desvioPadrao[i]);
        }
    }
}
