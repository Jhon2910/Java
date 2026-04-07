import java.util.Scanner;

public class jonathan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um caracter qualquer:");
        String c = sc.nextLine();

        if (c.length() != 1){
            System.out.println("Digite apenas um caracter!");
        }
        else {
            char caracter = Character.toLowerCase(c.charAt(0));

            if ((caracter == 'a') || (caracter == 'e') || ((caracter == 'i') || (caracter == 'o') || (caracter == 'u'))) {
                System.out.println("É uma Vogal!");
            } else {
                System.out.println("Não é uma Vogal!");
            }
        }
        sc.close();
    }
}
