import java.util.Scanner;

public class jonathan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, n;
        boolean diferente = true;

        int vet[] = new int[10];

        for (i = 0; i < vet.length; i++) {
            System.out.printf("Digite o %d valor : ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.println("Digite apenas valores inteiros!");
                System.out.printf("Digite o %d valor : ", i + 1);
                sc.next();
            }
            vet[i] = sc.nextInt();
        }
        System.out.println(" ");

        System.out.print("Digite um valor qualquer : ");
        while (!sc.hasNextInt()) {
            System.out.println("Digite apenas valores inteiros!");
            System.out.print("Digite um valor qualquer: ");
            sc.next();
        }
        n = sc.nextInt();


        System.out.print("\nVetor preenchido [");
        for (i = 0; i < vet.length; i++) {
            System.out.printf(" %d ", vet[i]);
        }
        System.out.println("]");


        for (i = 0; i < vet.length; i++) {
            if (vet[i] == n) {
                diferente = false;
                System.out.printf("\nO valor %d está na %dª posição do vetor", n,i+1);
            }
        }

        if (diferente) {
            System.out.printf("\nO valor %d não está presente no vetor.", n);
        }

        sc.close();
    }
}
