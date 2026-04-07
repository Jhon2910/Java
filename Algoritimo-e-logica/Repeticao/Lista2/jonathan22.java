import java.util.Scanner;

public class jonathan22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        double s = 1;
        double sinal = -1;
        double denominador,fracao,pi;

        for (denominador = 3; denominador < 51; denominador = denominador +2) {
            fracao = 1/Math.pow(denominador,3);
            s += sinal*fracao;
            sinal *= -1;
        }
        pi = Math.cbrt(s * 32);

        System.out.printf("PI = %.10f", pi);

        sc.close();
    }
}
