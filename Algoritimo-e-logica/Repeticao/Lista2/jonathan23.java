import java.util.Scanner;

public class jonathan23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double grau, radianos, sen = 0, fracao, fatorial;
        int sinal = 1;

        System.out.print("Digite o valor de X (em graus): ");
        grau = sc.nextDouble();

        radianos = grau * Math.PI / 180;

        for (int i = 0; i < 15; i++) {
            int expoente = 2 * i + 1;
            fatorial = 1;

            for (int j = 1; j <= expoente; j++) {
                fatorial *= j;
            }

            fracao = Math.pow(radianos, expoente) / fatorial;
            sen += sinal * fracao;
            sinal *= -1;
        }

        System.out.printf("Sen(x) = %.10f\n", sen);
        sc.close();
    }
}
