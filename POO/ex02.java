import java.util.Scanner;

public class ex02 {
    static Scanner sc = new Scanner(System.in);

    public static boolean isZero(float num){
        if (num != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        float num;
        System.out.println("Digite um valor numerico para saber se ele e nulo ou nao: ");
        if (!sc.hasNextFloat()){
            System.out.print("Erro!");
        }
        num = sc.nextFloat();

        if (isZero(num)){
            System.out.println("nao nulo");
        }
        else {
            System.out.println("nulo");
        }
    }
}
