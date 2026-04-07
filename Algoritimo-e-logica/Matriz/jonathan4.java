import java.util.Scanner;

public class jonathan4 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int alunos = 10;
        int notas = 5;

        int matriz[][] = new int[alunos][notas];
        String nome[] = new String[alunos];
        double media[] = new double[alunos];

        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("Digite o nome do aluno %d: ", i + 1);
            nome[i] = sc.nextLine();

            if (!nome[i].matches("[A-Za-zÀ-ÿ ]+")) {
                System.out.print("Digite um nome válido (apenas letras e espaços): ");
                i--;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            int soma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Digite a nota %d do aluno %s: ", j + 1, nome[i]);
                while (!sc.hasNextInt()) {
                    System.out.print("Digite apenas números inteiros para as notas.");
                    System.out.printf("Digite a nota %d do aluno %s: ", j + 1, nome[i]);
                    sc.next();
                }
                matriz[i][j] = sc.nextInt();
                soma += matriz[i][j];
            }
            media[i] = (double) soma / notas;
        }
        imprimir(matriz, nome, media);
    }

    public static void imprimir(int matriz[][], String nome[], double media[]) {

        for (int i = 0; i < matriz.length;i++) {
            System.out.println(nome[i]+" "+media[i]);
            if (media[i] >= 7){
                System.out.println("Aprovado");
            } else if (media[i] >= 4 && media[i] <= 7) {
                System.out.println("Exame especial");
            }
            else {
                System.out.println("Reprovado");
            }
        }

    }
}
