import java.util.Scanner;

public class jonathan6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i;

        System.out.print("Digite quantos valores da serie de Fibonacci você quer ir: ");
        while (!sc.hasNextInt()) {
            System.out.print("Digite um valor inteiro!");
            System.out.print("Digite quantos valores da serie de Fibonacci você quer ir: ");
            sc.next();
        }
        n = sc.nextInt();

        int Fibonacci[] = new int[n];

        System.out.print("Fibonacci = [");
        for (i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                Fibonacci[i] = 1;
            } else {
                Fibonacci[i] = (Fibonacci[i - 1]) + (Fibonacci[i - 2]);
            }
            if (i == (n-1)) {
                System.out.printf("%d",Fibonacci[i]);
            }
            else {
                System.out.printf("%d,", Fibonacci[i]);
            }
        }
        System.out.print("]");
        sc.close();
    }
}
