import java.util.Scanner;

public class jonathan16{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um ano: ");

        if (sc.hasNextInt()) {
            int ano = sc.nextInt();

            if (ano <= 0) {
                System.out.println("Por favor, insira um ano válido (número positivo).");
            }
            else {
                if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                    System.out.println("O ano " + ano + " é bissexto.");
                }
                else {
                    System.out.println("O ano " + ano + " não é bissexto.");
                }
            }
        }
        else {
            System.out.print("Digite apenas numeros inteiros!");
        }
        sc.close();
    }
}
