import java.util.Scanner;

public class jonathan10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, j, aux;
        int vet1[] = new int[10];
        int vet2[] = new int[10];
        int vet3[] = new int[20];

        int menorN = Integer.MAX_VALUE;
        int menor[] = new int[20];

        for (i = 0; i < vet1.length; i++) {
            System.out.printf("Digite o %d numero do vetor 1: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.print("Digite um numero inteiro!");
                System.out.printf("Digite o %d numero do vetor 1: ", i + 1);
                sc.next();
            }
            vet1[i] = sc.nextInt();

        }
        for (i = 0; i < vet1.length; i++) {
            System.out.printf("Digite o %d numero do vetor 2: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.print("Digite um numero inteiro!");
                System.out.printf("Digite o %d numero do vetor 2: ", i + 1);
                sc.next();
            }
            vet2[i] = sc.nextInt();

        }

        for (i = 0; i < vet1.length; i++) {
            vet3[i] = vet1[i];

        }
        for (i = 0; i < vet2.length; i++) {
            vet3[vet2.length + i] = vet2[i];
        }


        for (i = 0; i < vet3.length - 1; i++) {
            for (j = 0; j < vet3.length - 1 - i; j++) {
                if (vet3[j] > vet3[j + 1]) {
                    aux = vet3[j];
                    vet3[j] = vet3[j + 1];
                    vet3[j + 1] = aux;
                }
            }
        }

        System.out.print("Vet 3 = [");
        for (i = 0; i < vet3.length; i++) {

            if (i < vet3.length -1) {
                System.out.print(vet3[i] + ",");
            }
             else {
                System.out.print(vet3[i]);
            }
        }
        System.out.print("]");
    }
}
