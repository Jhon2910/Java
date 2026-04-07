import java.util.Scanner;

public class jonathan17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");

        if (sc.hasNextDouble()) {
            double n1 = sc.nextDouble();

            System.out.print("Digite o segundo número: ");

            if (sc.hasNextDouble()) {
                double n2 = sc.nextDouble();

                System.out.print("Digite o terceiro número: ");

                if (sc.hasNextDouble()) {
                    double n3 = sc.nextDouble();

                    double menor, meio, maior;

                    if (n1 <= n2 && n1 <= n3) {
                        menor = n1;
                        if (n2 <= n3) {
                            meio = n2;
                            maior = n3;
                        }
                        else {
                            meio = n3;
                            maior = n2;
                        }
                    }
                    else if (n2 <= n1 && n2 <= n3) {
                        menor = n2;
                        if (n1 <= n3) {
                            meio = n1;
                            maior = n3;
                        } else {
                            meio = n3;
                            maior = n1;
                        }
                    }
                    else {
                        menor = n3;
                        if (n1 <= n2) {
                            meio = n1;
                            maior = n2;
                        } else {
                            meio = n2;
                            maior = n1;
                        }
                    }

                    System.out.println("Ordem Crescente: " + menor + ", " + meio + ", " + maior);
                    System.out.println("Ordem Decrescente: " + maior + ", " + meio + ", " + menor);

                }
                else {
                    System.out.print("Digite apenas numeros!");
                }

            }
        }
        sc.close();
    }
}
