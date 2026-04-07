import java.util.Scanner;

public class jonathan15{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro de 4 dígitos: ");
        
        if (sc.hasNextInt()) {
            int numero = sc.nextInt();

            if (numero >= 1000 && numero <= 9999) {

                int digito1 = numero / 1000;
                int digito2 = (numero / 100) % 10;
                int digito3 = (numero / 10) % 10;
                int digito4 = numero % 10;

                if ((digito1 == 0 || digito1 == 1) && (digito2 == 0 || digito2 == 1) && (digito3 == 0 || digito3 == 1) && (digito4 == 0 || digito4 == 1)) {

                    int valorDecimal = (digito1 * 8) + (digito2 * 4) + (digito3 * 2) + (digito4 * 1);

                    System.out.println("O número " + numero + " pertence à família dos binários.");
                    System.out.println("Seu valor correspondente em decimal é: " + valorDecimal);

                } else {
                    System.out.println("O número " + numero + " não pertence à família dos binários, pois contém dígitos diferentes de 0 e 1.");
                }

            } else {
                System.out.println("O valor digitado não possui 4 dígitos.");
            }

            sc.close();
        }
        else {
            System.out.print("Digite apenas numeros inteiros!");
        }
    }
}
