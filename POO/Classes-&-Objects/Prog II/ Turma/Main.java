import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno[] alunos = new Aluno[5];

        for (int i = 0; i < alunos.length; i++) {
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o numero: ");
            int numero = sc.nextInt();
            sc.nextLine(); // limpa o Enter

            alunos[i] = new Aluno(nome, numero);
        }

        sc.close(); // fecha UMA vez só, depois do loop

        System.out.println("\n--- Turma ---");
        for (Aluno a : alunos) {
            a.exibir(); // ✅ chama o método, não imprime o objeto direto
        }
    }
}
