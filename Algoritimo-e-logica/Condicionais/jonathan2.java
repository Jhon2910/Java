import java.util.Scanner;

public class jonathan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");

        if (sc.hasNextInt()) {

            int n = sc.nextInt();

            int resto = n % 2;

            if (resto == 0) {
                System.out.println("O número que você digitou é par!");
            }
            else {
                System.out.println("O número que voce digitou é impar!");
            }
        }

        else {
            System.out.println("Digite apenas números inteiros!");
        }
        sc.close();
    }
}
