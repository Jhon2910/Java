import java.util.Scanner;

public class jonathan8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor: ");
        
        if (sc.hasNextDouble()) {
            double x = sc.nextDouble();

            if (x <= 1 ) {
                System.out.println("F(X) = " + 1);
            }
            else if (x > 1 && x <= 2) {
                System.out.println("F(X) = " + 2);
            }
            else if (x > 2 && x <= 3) {
                System.out.println("F(X) = " + Math.pow(x,2));
            }
            else {
                System.out.println("F(X) = " + Math.pow(x,3));
            }
        }
        else  {
            System.out.println("Digite apenas numeros reais!");
        }

        sc.close();
    }
}
