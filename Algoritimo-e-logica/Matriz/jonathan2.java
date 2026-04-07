import java.util.Scanner;

public class jonathan2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        

        int linha = 3;
        int coluna = 5;
        double maior = Integer.MIN_VALUE;

        double matriz[][] = new double[linha][coluna];
        double vet[] = new double[coluna];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 0) {
                    System.out.printf("\n-----------Linha %d ----------\n", i + 1);
                }
                System.out.printf("Digite o %dº valor :", j + 1);
                matriz[i][j] = sc.nextInt();
                vet[i] += matriz[i][j];
            }
        }
        op(maior,matriz,vet);
    }

    static void op(double maior,double matriz[][],double vet[]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (maior < vet[i]){
                    maior = vet[i];
                }
            }
        }
    }
}
