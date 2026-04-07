import java.util.Scanner;

public class jonathan12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimensões da matriz A");
        System.out.print("Linhas: ");
        int linhasA = sc.nextInt();
        System.out.print("Colunas: ");
        int colunasA = sc.nextInt();

        int[][] A = new int[linhasA][colunasA];
        System.out.println("Entre com os valores para A:");
        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasA; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nDimensões da matriz B");
        System.out.print("Linhas: ");
        int linhasB = sc.nextInt();
        System.out.print("Colunas: ");
        int colunasB = sc.nextInt();

        int[][] B = new int[linhasB][colunasB];
        System.out.println("Entre com os valores para B:");
        for (int i = 0; i < linhasB; i++) {
            for (int j = 0; j < colunasB; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = sc.nextInt();
            }
        }

        if (colunasA == linhasB) {
            System.out.println("\nMultiplicação possível.");

            int[][] C = new int[linhasA][colunasB];

            for (int i = 0; i < linhasA; i++) {
                for (int j = 0; j < colunasB; j++) {
                    int soma = 0;
                    for (int k = 0; k < colunasA; k++) {
                        soma += A[i][k] * B[k][j];
                    }
                    C[i][j] = soma;
                }
            }

            System.out.println("\nMatriz C:");
            for (int i = 0; i < linhasA; i++) {
                for (int j = 0; j < colunasB; j++) {
                    System.out.print(C[i][j] + "\t");
                }
                System.out.println();
            }

        } else {
            System.out.println("\nMultiplicação não é possível.");
            System.out.println("Colunas de A (" + colunasA + ") diferente de linhas de B (" + linhasB + ").");
        }

        sc.close();
    }
}
