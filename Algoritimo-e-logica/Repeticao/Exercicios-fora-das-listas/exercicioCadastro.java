import java.util.Scanner;

public class jonathanExercico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, email, senha;
        int idade;

        while (true) {
            System.out.print("Seu nome: ");
            nome = sc.nextLine();
            if (nome.length() <= 2) {
                System.out.println("Nome muito curto.\n");
                continue;
            }

            System.out.print("Sua idade: ");
            if (!sc.hasNextInt()) {
                System.out.println("Digite uma idade válida.\n");
                sc.next();
                continue;
            }
            idade = sc.nextInt();
            sc.nextLine();
            if (idade < 0 || idade > 150) {
                System.out.println("Idade fora do limite.\n");
                continue;
            }

            System.out.print("Seu email: ");
            email = sc.nextLine();
            if (!email.contains("@")) {
                System.out.println("Email precisa ter '@'.\n");
                continue;
            }

            System.out.print("Sua senha: ");
            senha = sc.nextLine();

            boolean temMaiuscula = senha.matches(".*[A-Z].*");
            boolean temMinuscula = senha.matches(".*[a-z].*");
            boolean temNumero    = senha.matches(".*[0-9].*");
            boolean temEspecial  = senha.matches(".*[#*_!@].*");

            if (!temMaiuscula || !temMinuscula || !temNumero || !temEspecial) {
                System.out.println("A senha deve conter letra MAIÚSCULA, minúscula, número e símbolo (# * _ ! @).\n");
                continue;
            }
            break;
        }
        System.out.println("\nCadastro feito com sucesso. Bem-vindo, " + nome + "!");
        sc.close();
    }
}
