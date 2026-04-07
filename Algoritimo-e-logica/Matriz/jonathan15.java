import java.util.Scanner;

public class jonathan15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[5][5];

        System.out.println("Preenchendo a matriz de amizades (0 ou 1):");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    System.out.println("n" + i + " é amigo de n" + j + "? (1=sim, 0=não)");
                    int valor = sc.nextInt();
                    matriz[i][j] = valor;
                    matriz[j][i] = valor;
                }
            }
        }

        System.out.println("Quantidade de amigos de cada pessoa:");
        for (int i = 0; i < 5; i++) {
            int amigos = 0;
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] == 1) {
                    amigos++;
                }
            }
            System.out.println("n" + i + " tem " + amigos + " amigo(s).");
        }

        sc.close();
    }
}
