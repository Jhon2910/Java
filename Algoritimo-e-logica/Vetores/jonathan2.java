import java.util.Scanner;

class jonathan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;

        int[] vet1 = new int[10];
        int[] vet2 = new int[10];
        int[] vet3 = new int[10];

        for (i = 0; i < 10; i++) {
            System.out.printf("Digite o %dº valor do vetor 1: ", (i + 1));
            while (!sc.hasNext()) {
                System.out.println("Digite um valor inteiro!");
                System.out.printf("Digite o %dº valor do vetor 1: ", (i + 1));
                sc.next();
            }
            vet1[i] = sc.nextInt();
        }
        System.out.println(" ");
        for (i = 0; i < 10; i++) {
            System.out.printf("Digite o %dº valor do vetor 2: ", (i + 1));
            while (!sc.hasNext()) {
                System.out.println("Digite um valor inteiro!");
                System.out.printf("Digite o %dº valor do vetor 2: ", (i + 1));
                sc.next();
            }
            vet2[i] = sc.nextInt();
        }
        for (i = 0; i < 10; i++) {
            vet3[i] = vet1[i] + vet2[i];
        }

        System.out.print("\n----------------------------------------");
        for (i = 0; i <= 9;i++) {
            if (i == 0) {
                System.out.printf("\nvet1 = [ %d ", vet1[0]);
            } else if (i == 9) {
                System.out.printf(" %d ]", vet1[9]);
            } else {
                System.out.printf(" %d ", vet1[i]);
            }

        }
        System.out.print("\n----------------------------------------");
        for (i = 0; i <= 9; i++) {
            if (i == 0) {
                System.out.printf("\nvet2 = [ %d ", vet2[0]);
            } else if (i == 9) {
                System.out.printf(" %d ]", vet2[9]);
            } else {
                System.out.printf(" %d ", vet2[i]);
            }
        }
        System.out.print("\n----------------------------------------");
        for (i = 0; i <= 9; i++) {
            if (i == 0) {
                System.out.printf("\nvet3 = [ %d ", vet3[0]);
            } else if (i == 9) {
                System.out.printf(" %d ]", vet3[9]);
            } else {
                System.out.printf(" %d ", vet3[i]);
            }
        }
        sc.close();
    }
}
