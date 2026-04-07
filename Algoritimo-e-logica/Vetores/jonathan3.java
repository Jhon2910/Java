import java.util.Scanner;

public class jonathan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;

        int[] vet1 = new int[10];
        int[] vet2 = new int[10];
        int[] vet3 = new int[10];

        for (i = 0; i < vet1.length; i++) {
            System.out.printf("Digite o %dº numero para o vet1 : ", (i + 1));
            while (!sc.hasNextDouble()) {
                System.out.print("Digite um numero valido!");
                System.out.printf("Digite o %dº numero para o vet1 : ", (i + 1));
                sc.next();
            }
            vet1[i] = sc.nextInt();

        }

        System.out.println(" ");

        for (i = 0; i < vet2.length; i++) {
            System.out.printf("Digite o %dº numero para o vet2 : ", (i + 1));
            while (!sc.hasNextDouble()) {
                System.out.print("Digite um numero valido!");
                System.out.printf("Digite o %dº numero para o vet2 : ", (i + 1));
                sc.next();
            }
            vet2[i] = sc.nextInt();
        }

        System.out.println(" ");

        for (i = 0; i < vet3.length; i++) {
            vet3[i] = 1;
            if (vet1[i] == vet2[i]) {
                vet3[i] = 0;
            }
        }

        System.out.println(" ");

        System.out.print("Vet1 = [");
        for (i = 0; i < vet1.length; i++) {
            System.out.printf(" %d ", vet1[i]);
        }
        System.out.print(" ]");

        System.out.print("\nVet2 = [");
        for (i = 0; i < vet1.length; i++) {
            System.out.printf(" %d ", vet2[i]);
        }
        System.out.print(" ]");

        System.out.print("\nVet3 = [");
        for (i = 0; i < vet1.length; i++) {
            System.out.printf(" %d ", vet3[i]);
        }
        System.out.print(" ]");

        System.out.println(" ");
    }
}
