import java.util.Scanner;

public class ex01 {
    static Scanner sc = new Scanner(System.in);

    public static boolean isPositive(float num) {

        if (num < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        float num;
        System.out.print("Digite um numero para saber se ele e positivo ou negativo: ");
        if (!sc.hasNext()) {
            System.out.print("Erro!");
        }
        num = sc.nextFloat();

        if (isPositive(num)){
            System.out.println("positivo");
        }
        else {
            System.out.println("negativo");
        }
    }
}
