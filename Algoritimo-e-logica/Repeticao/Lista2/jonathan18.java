import java.util.Scanner;

public class jonathan18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double quantidadeUsuario, n;
        int quantidade;
        int somaPar = 0, somaImpar = 0;
        int qtdPar = 0, qtdImpar = 0;
        int maiorPar = Integer.MIN_VALUE;
        int menorImpar = Integer.MAX_VALUE;

        while (true) {
            System.out.print("\nDigite a quantidade de numeros que gostaria de digitar: ");
            while (!sc.hasNextInt()) {
                System.out.println("Número inválido! Tente novamente!");
                System.out.print("Digite a quantidade de numeros que gostaria de digitar: ");
                sc.next();
            }

            quantidadeUsuario = sc.nextInt();
            quantidade = 1;

            while (quantidade <= quantidadeUsuario) {
                System.out.printf("Digite o %dº valor (negativo para sair): ", quantidade);
                n = sc.nextDouble();

                if (n < 0) {
                    System.out.println("\nNúmero negativo digitado. Encerrando...");
                    if (qtdPar > 0) {
                        double mediaPares = (double) somaPar / qtdPar;
                        System.out.printf("\nMédia dos pares: %.2f", mediaPares);
                        System.out.printf("\nMaior número par: %d", maiorPar);
                    } else {
                        System.out.println("\nNenhum número par foi digitado.");
                    }

                    if (qtdImpar > 0) {
                        double mediaImpares = (double) somaImpar / qtdImpar;
                        System.out.printf("\nMédia dos ímpares: %.2f", mediaImpares);
                        System.out.printf("\nMenor número ímpar: %d", menorImpar);
                    } else {
                        System.out.println("\nNenhum número ímpar foi digitado.");
                    }
                    return;
                }

                if ((int)n % 2 == 0) {
                    somaPar += n;
                    qtdPar++;
                    if (n > maiorPar) {
                        maiorPar = (int)n;
                    }
                } else {
                    somaImpar += n;
                    qtdImpar++;
                    if (n < menorImpar) {
                        menorImpar = (int)n;
                    }
                }

                quantidade++;
            }

            if (qtdPar > 0) {
                double mediaPares = (double) somaPar / qtdPar;
                System.out.printf("\nMédia dos pares: %.2f", mediaPares);
                System.out.printf("\nMaior número par: %d", maiorPar);
            } else {
                System.out.println("\nNenhum número par foi digitado.");
            }

            if (qtdImpar > 0) {
                double mediaImpares = (double) somaImpar / qtdImpar;
                System.out.printf("\nMédia dos ímpares: %.2f", mediaImpares);
                System.out.printf("\nMenor número ímpar: %d", menorImpar);
            } else {
                System.out.println("\nNenhum número ímpar foi digitado.");
            }
        }
    }
}
