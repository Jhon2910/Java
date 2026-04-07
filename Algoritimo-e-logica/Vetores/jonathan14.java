import java.util.Scanner;

public class jonathan14 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int QuantLatas = 20;
        double soma = 0;
        double latas[] = new double[QuantLatas];

        for (int i = 0; i < QuantLatas; i++) {
            System.out.print("Digite o valor de volume da lata " + (i + 1) + " em (ml): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                System.out.print("Digite o valor de volume da lata " + (i + 1) + " em (ml): ");
                sc.next();
            }
            latas[i] = sc.nextDouble();
            if (latas[i] < 0 || latas[i] > 390) {
                System.out.println("Valor inválido. O volume não pode ser negativo ou maior que o tamanho da lata e ml(390).");
                i--;
            } else {
                soma += latas[i];
            }
        }

        calculos(soma, QuantLatas, latas);
        sc.close();
    }

    public static void calculos(double soma, int QuantLatas, double[] latas) {

        int media = (int) soma / QuantLatas;

        for (int i = 0; i < QuantLatas; i++) {
            latas[i] = Math.pow(latas[i] - media, 2);
        }

        double somaDesvios = 0;

        for (int i = 0; i < QuantLatas; i++) {
            somaDesvios += latas[i];
        }

        double mediaDesvioPadrao = somaDesvios / (QuantLatas - 1);

        double S = Math.sqrt(mediaDesvioPadrao);

        S(S);
    }

    public static void S(double S) {

        System.out.println("Desvio padrão: " + S);

        if (S > 5) {
            System.out.println("O processo precisa ser revisado.");
        } else {
            System.out.println("O processo está dentro dos padrões.");
        }
    }
}
