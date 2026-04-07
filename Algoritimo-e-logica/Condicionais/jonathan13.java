import java.util.Scanner;

public class jonthan13{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o primeiro lado:");

        if (sc.hasNextDouble()) {
            double lado1 = sc.nextDouble();
            System.out.println("Digite o segundo lado:");

            if (sc.hasNextDouble()) {
                double lado2 = sc.nextDouble();
                System.out.println("Digite o terceiro lado:");

                if (sc.hasNextDouble()) {
                    double lado3 = sc.nextDouble();

                    if (lado1 < lado2 + lado3 && lado2 < lado1 + lado3 && lado3 < lado1 + lado2) {
                        if (lado1 == lado2 && lado2 == lado3) {
                            System.out.println("Os valores formam um triângulo equilátero.");
                        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                            System.out.println("Os valores formam um triângulo isósceles.");
                        } else {
                            System.out.println("Os valores formam um triângulo escaleno.");
                        }
                    } else {
                        System.out.println("Os valores fornecidos não podem formar um triângulo.");
                    }
                    sc.close();
                }
                else {
                    System.out.print("Digite apenas numeros");
                }
            }
            else {
                System.out.print("Digite apenas numeros!");
            }
        }
        else {
            System.out.print("Digite apenas numeros!");
        }
    }
}
