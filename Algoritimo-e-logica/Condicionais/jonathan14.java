import java.util.Scanner;

public class jonathan14{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro de 3 dígitos: ");

        if (sc.hasNextInt()){
            int numero = sc.nextInt();

            if (numero >= 100 && numero <= 999) {
                int primeiroDigito = numero / 100;
                int ultimoDigito = numero % 10;

                if (primeiroDigito == ultimoDigito) {
                    System.out.println(numero + " é um palíndromo.");
                } else {
                    System.out.println(numero + " não é um palíndromo.");
                }
            } else {
                System.out.println("O número fornecido não possui 3 dígitos.");
            }
            sc.close();
        }
        else {
            System.out.print("Digite apenas numeros inteiros!");
        }
    }
}
