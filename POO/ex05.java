import java.util.Scanner;

public class ex05 {
    static Scanner sc = new Scanner(System.in);
    public static double delta(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static void main(String[] args) {

        System.out.println("-- Calculadora de Equação de 2º Grau --");
        System.out.println("Digite o valor do coeficiente a: ");
        double a = sc.nextDouble();

        System.out.println("Digite o valor do coeficiente b: ");
        double b = sc.nextDouble();

        System.out.println("Digite o valor do coeficiente c: ");
        double c = sc.nextDouble();
        sc.close();

        if (a == 0) {
            System.out.println("O coeficiente a não pode ser zero para uma eqação de 2º grau.");
            System.out.println("A solução não existe.");
            return;
        }

        double valorDelta = delta(a, b, c);
        System.out.println("O valor de delta é: " + valorDelta);

        System.out.println();

        if (valorDelta >= 0) {
            double x1 = (-b + Math.sqrt(valorDelta)) / (2 * a);
            double x2 = (-b - Math.sqrt(valorDelta)) / (2 * a);
            System.out.println("A equação possui raízes reais.");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            double parteReal = -b / (2 * a);
            double parteImaginaria = Math.sqrt(-valorDelta) / (2 * a);
            System.out.println("A equação possui raízes complexas.");
            System.out.println("x1 = " + parteReal + " + " + parteImaginaria + "i");
            System.out.println("x2 = " + parteReal + " - " + parteImaginaria + "i");
        }
    }
}
