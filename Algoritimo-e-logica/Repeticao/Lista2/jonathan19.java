import java.util.Scanner;

public class jonathan19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numeroOriginal = sc.nextInt();

        int numero = numeroOriginal;
        int numeroRevertido = 0;

        while (numero > 0) {
            int ultimoDigito = numero % 10;
            numeroRevertido = numeroRevertido * 10 + ultimoDigito;
            numero = numero / 10;
        }

        if (numeroOriginal == numeroRevertido) {
            System.out.println(numeroOriginal + " é um PALÍNDROMO.");
        } else {
            System.out.println(numeroOriginal + " não é um PALÍNDROMO.");
        }

        sc.close();
    }
}
