import java.util.Scanner;

class jonathan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, somaMenor = 0, somaMaior = 0, somaIdades = 0;
        double media;

        int[] idade = new int[40];

        int idadeMaior = Integer.MIN_VALUE;
        int idadeMenor = Integer.MAX_VALUE;

        for (i = 0; i < 40; i++) {
            System.out.printf("\nDigite a idade do %dº aluno: ", (i + 1));
            while (!sc.hasNextInt()) {
                System.out.print("\nDigite apenas numeros inteiros!");
                System.out.printf("\nDigite a idade do %dº aluno: ", (i + 1));
                sc.next();
            }
            idade[i] = sc.nextInt();
            somaIdades += idade[i];

            if (idade[i] <= 16) {
                somaMenor += 1;
            } else {
                somaMaior += 1;
            }
            if (idade[i] > idadeMaior) {
                idadeMaior = idade[i];
            }
            if (idade[i] < idadeMenor) {
                idadeMenor = idade[i];
            }
        }
        media = (double) somaIdades / 40;

        System.out.printf("\nO Total de alunos com idade menor ou igual a 16 anos é: %d", somaMenor);
        System.out.printf("\nO Total de alunos com idade maior que 16 anos: %d", somaMaior);
        System.out.printf("\nA Média das idades  é: %.2f", media);
        System.out.printf("\nA Idade do aluno mais novo é: %d", idadeMenor);
        System.out.printf("\nA Idade do aluno mais velho é: %d", idadeMaior);

        sc.close();
    }
}
