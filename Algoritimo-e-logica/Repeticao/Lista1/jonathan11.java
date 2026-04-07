import java.util.Scanner;

public class jonathan11 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int alunos;
        int i = 1;
        int soma = 0;
        String nome;
        double nota;
        double menornota = Double.MAX_VALUE;
        String nomemenor = "";
        double maiornota = Double.MIN_VALUE;
        String nomemaior = "";

        System.out.print("Digite a quantidade de alunos :");
        while (!sc.hasNextInt()){
            System.out.print("Digite numeros validos: ");
            sc.next();
        }
        alunos = sc.nextInt();
        sc.nextLine();

        while (i <= alunos) {
            System.out.printf("\nDigite o nome do %d aluno: ",i);
            nome = sc.nextLine();
            System.out.printf("Digite a nota do aluno %s: ",nome);

            while (!sc.hasNextDouble()) {
                System.out.print("\nDigite um numero valido:  ");
                sc.next();
            }
            nota = sc.nextDouble();
            soma += (int) nota;
            sc.nextLine();

            if (nota < menornota){
                menornota = nota;
                nomemenor = nome;


            }
            if (nota > maiornota){
                maiornota = nota;
                nomemaior = nome;
            }

            i++;
        }

        double media = (double) soma/alunos;
        System.out.printf("\nA soma das notas e %d e a media das notas e %.2f",soma,media);
        System.out.printf("\nA menor nota e %.2f do aluno %s",menornota,nomemenor);
        System.out.printf("\nA maior nota e %.2f do aluno %s",maiornota,nomemaior);

        sc.close();
    }
}
