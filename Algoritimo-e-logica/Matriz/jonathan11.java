import java.util.Random;
import java.util.Scanner;

public class jonathan11 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();


        int matriz[][] = new int[5][3];
        int a[] = new int[4];
        int b = Integer.MIN_VALUE;
        int c = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        int maiorB = 0;
        int menorC = 0;
        int soma[] = new int[4];
        int arm=0;


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 4) {
                    System.out.printf("Digite o custo de estocagem do %d produto: ", j + 1);
                    matriz[i][j] = sc.nextInt();
                } else {
                    System.out.printf("Estoque produto %d no %d armazem: ", j + 1, i + 1);
                    matriz[i][j] = sc.nextInt();
                }
            }
            System.out.println(" ");
        }

        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                a[i] += matriz[i][j];

                soma[i] += matriz[i][j] * matriz[4][j];
                if (d < soma[i]) {
                    d = soma[i];
                    arm = i;
                }

                if (b < matriz[i][1]) {
                    b = matriz[i][1];
                    maiorB = i;
                }
                if (c > a[i]) {
                    c = a[i];
                    menorC = i;
                }

            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.printf("\nA quantidade de itens no armazem %d e: %d", i + 1,a[i]);
        }

        System.out.println("O armazenamento que o maior estoque do produto 2 e o : " + maiorB);
        System.out.println("O armazenamento que possui o menor estoque e o: " + menorC);
        System.out.println("O armazenamento que possui o maior custo de estocagem e o: " + arm);

    }
}
