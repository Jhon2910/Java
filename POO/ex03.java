import java.util.Scanner;

public class ex03 {
    static Scanner sc = new Scanner(System.in);

    public static boolean isEven(float num){
        if (num % 2 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        float num;

        System.out.print("Digite um numero para saber se ele e par ou impar: ");
        if (!sc.hasNextFloat()){
            System.out.println("Erro!");
        }
        num = sc.nextFloat();

        if (isEven(num)){
            System.out.print("Par");
        }
        else {
            System.out.print("Impar");
        }
    }
}
