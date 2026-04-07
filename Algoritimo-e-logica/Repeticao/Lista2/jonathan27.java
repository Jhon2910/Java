import java.util.Scanner;

public class jonathan27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int altura, i, j;

        System.out.print("Digite a altura do triangulo: ");
        while (!sc.hasNextInt()) {
            System.out.println("\nDigite um numero positivo!");
            System.out.print("Digite a altura do triangulo: ");
            sc.next();
        }
        altura = sc.nextInt();

        for (i = 1; i <= altura; i++) {
            if (i==altura){
                System.out.println("#");
                return;
            }
            System.out.println("#");
            for (j = 0; j < i; j++) {
                System.out.print("#");
            }

        }

        sc.close();
    }
}
