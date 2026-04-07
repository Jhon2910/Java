import java.util.Scanner;

public class jonathan9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int totalAlunos = 50;
        double[] altura = new double[totalAlunos];
        int[] sexo = new int[totalAlunos];

        int totalHomens = 0, totalMulheres = 0;
        double somaAlturas = 0;

        for (int i = 0; i < totalAlunos; i++) {
            System.out.printf("\nDigite a altura do aluno %d (em metros): ", i + 1);
            while (!sc.hasNextDouble()) {
                System.out.print("Altura inválida! Digite novamente: ");
                sc.next();
            }

            altura[i] = sc.nextDouble();
            if (altura[i] < 0) {
                System.out.print("A altura deve ser positiva. Tente novamente.");
                i--;
                continue;
            }

            System.out.printf("Digite o sexo do aluno %d (1 para masculino, 2 para feminino): ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.print("Sexo inválido! Digite 1 ou 2: ");
                sc.next();
            }

            sexo[i] = sc.nextInt();
            if (sexo[i] != 1 && sexo[i] != 2) {
                System.out.print("Digite apenas 1 para masculino ou 2 para feminino.");
                i--;
                continue;
            }

            if (sexo[i] == 1) totalHomens++;
            else totalMulheres++;

            somaAlturas += altura[i];
        }

        double media = somaAlturas / totalAlunos;

        ordenarAlturas(altura);

        for (int i = 0; i < totalAlunos; i++) {
            if (altura[i] < media) {
                if (sexo[i] == 1) {
                    System.out.printf("O homem %d está abaixo da média.\n", i + 1);
                } else {
                    System.out.printf("A mulher %d está abaixo da média.\n", i + 1);
                }
            }
        }
        resultados(altura, media);
    }

    public static void ordenarAlturas(double[] altura) {
        double aux;
        for (int i = 0; i < altura.length - 1; i++) {
            for (int j = 0; j < altura.length - 1 - i; j++) {
                if (altura[j] > altura[j + 1]) {
                    aux = altura[j];
                    altura[j] = altura[j + 1];
                    altura[j + 1] = aux;
                }
            }
        }
    }

    public static void resultados(double[] altura, double media) {
        System.out.printf("\n📏 Menor altura: %.2f m", altura[0]);
        System.out.printf("\n📏 Maior altura: %.2f m", altura[altura.length - 1]);
        System.out.printf("\n📊 Média das alturas: %.2f m\n", media);
    }
}
