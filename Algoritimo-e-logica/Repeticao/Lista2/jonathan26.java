import java.util.Scanner;

public class jonathan26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, i, j;

        System.out.print("Digite um numero inteiro: ");
        while (!sc.hasNextInt()) {
            System.out.println("\nDigite apenas numeros inteiros!");
            System.out.print("Digite um numero inteiro: ");
            sc.next();
        }
        n = sc.nextInt();

        for (i = 1; i <= n; i++) {
            for (j = 1;j <= n;j++){
                int mult = i * j;
                System.out.printf("\n%d x %d = %d", i, j, mult);
            }
            System.out.println("\n");
        }
        sc.close();
    }
}
