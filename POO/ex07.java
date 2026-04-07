import java.util.Scanner;

public class ex07 {
    static Scanner sc = new Scanner(System.in);

    public static double media(int t, int vet[]) {
        int soma = 0;
        double media = 0;
        
        for (int i = 0; i < t; i++) {
            System.out.printf("\nDigite o %d numero: ", i + 1);
            vet[i] = sc.nextInt();
            soma += vet[i];
        }

        return media = soma / (double) t;
    }

    public static void main(String[] args) {

        System.out.print("Digite tamanho do vetor: ");
        int t = sc.nextInt();

        int vet[] = new int[t];

        System.out.println(media(t, vet));

    }
}
