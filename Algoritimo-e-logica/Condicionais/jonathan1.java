import java.util.Scanner;

public class jonathan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a idade do atleta: ");

        if (sc.hasNextInt()) {
            int idade = sc.nextInt();

            if (idade < 5) {
                System.out.print("Idade invalida!");
            }
            else if (idade >= 5 && idade <= 7) {
                System.out.print("Infantil!");
            }
            else if (idade >= 8 && idade <= 10) {
                System.out.print("Juvenil!");
            }
            else if (idade >= 11 && idade <= 15) {
                System.out.print("Adolescente!");
            }
            else if (idade >= 16 && idade <= 40) {
                System.out.print("Adulto!");
            }
            else {
                System.out.print("Sênior!");
            }
        }
        else {
            System.out.println("Digite um valor inteiro!");
        }

        sc.close();
    }
}
