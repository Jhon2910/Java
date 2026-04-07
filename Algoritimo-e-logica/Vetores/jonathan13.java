import java.util.Scanner;

public class jonathan13 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int i, j, aux;
        int vet[] = new int[10];

        System.out.print("Digite 10 numeros!");

        for (i = 0; i < vet.length; i++) {
            System.out.printf("\n%dº numero: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.println("Digite apenas numeros inteiros!");
                System.out.print("Digite 10 numeros!");
                sc.next();
            }
            vet[i] = sc.nextInt();
        }

        for (i = 0; i < vet.length - 1; i++) {
            for (j = 0; j < vet.length - i - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
        sc.close();
        print(i, vet);
    }

    public static void print(int i, int vet[]) {
        System.out.println(" ");
        System.out.print("A ordem crescente é: ");
        for (i = 0; i < vet.length; i++) {
            System.out.print( vet[i] );
        }
    }
}
