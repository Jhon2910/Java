import java.util.Random;
import java.util.Scanner;

public class jonathan9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random r = new Random();
        int cidades;
        int rota = 0;

        System.out.println("cidades: ");
        cidades = sc.nextInt();


        int A[][] = new int[cidades][cidades];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.printf("Digite o custo da cidade %d para a cidade %d", i, j);
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Digite quantas cidades quer colocar na rota: ");
        int n = sc.nextInt();

        int vet[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println("Digite a rota de partida: ");
                vet[i] = sc.nextInt();
            } else {
                System.out.printf("Digite a %d cidade: ", i + 1);
                vet[i] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == n-1) {
                System.out.println(rota);
            } else {
                int z = vet[i];
                int x = vet[i + 1];
                rota += A[z][x];
            }
        }

    }
}
