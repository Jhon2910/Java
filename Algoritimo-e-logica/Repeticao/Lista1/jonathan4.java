import java.util.Scanner;

public class jonathan4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Digite um número para ver o seu triplo(Digite -999 para encerrar.).");

        while (true) {
            System.out.print("Digite um número: ");
            if (sc.hasNextInt()){
            n = sc.nextInt();

            if (n == -999) {
                System.out.println("encerrado.");
                break;
            }
            int triplo = n * 3;
            System.out.println("O triplo de " + n + " é: " + triplo);
            }
            else {
                System.out.println("Digite apenas números inteiros!");
                break;
            }
        }

        sc .close();
    }
}
