import java.util.Scanner;

public class Exercicio_de_sabado{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do usuário: ");
        String usuario = sc.nextLine();

        System.out.print("Digite a senha(Apenas numeros inteiros!): ");

        if (sc.hasNextInt()) {
            int senha = sc.nextInt();

            if (usuario.equals("admin")) {
                if (senha == 12345) {
                    System.out.println("Acesso concedido. Bem-vindo,admin!");
                } else {
                    System.out.println("Senha incorreta!");
                }
            } else {
                System.out.println("Usuário não encontrado");
            }
        }
            else {
                System.out.println("Digite apenas numeros!");
            }
            sc.close();
    }
}
