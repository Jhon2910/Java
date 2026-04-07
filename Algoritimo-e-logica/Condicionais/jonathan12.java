import java.util.Scanner;

public class jonathan12{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ano da votação: ");

        if (sc.hasNextInt()) {
            int anoVotacao = sc.nextInt();

            System.out.print("Digite o mês da votação: ");
            if (sc.hasNextInt()) {
                int mesVotacao = sc.nextInt();

                System.out.print("Digite o dia da votação: ");
                if (sc.hasNextInt()) {
                    int diaVotacao = sc.nextInt();

                    System.out.print("Digite o ano de nascimento: ");
                    if (sc.hasNextInt()) {
                        int anoNascimento = sc.nextInt();

                        System.out.print("Digite o mês de nascimento: ");
                        if (sc.hasNextInt()) {
                            int mesNascimento = sc.nextInt();

                            System.out.print("Digite o dia de nascimento: ");
                            if (sc.hasNextInt()) {
                                int diaNascimento = sc.nextInt();

                                int idade = anoVotacao - anoNascimento;

                                if (mesVotacao < mesNascimento || (mesVotacao == mesNascimento && diaVotacao < diaNascimento)) {
                                    idade--;
                                }

                                System.out.printf("Idade na data da votação: %d anos.\n", idade);
                                System.out.print("Situação de voto: ");

                                if (idade < 16) {
                                    System.out.println("Não pode votar.");
                                } else if (idade >= 18 && idade <= 70) {
                                    System.out.println("Voto Obrigatório.");
                                } else {
                                    System.out.println("Voto Facultativo.");
                                }

                            }
                            else {
                                System.out.println("O dia de nascimento deve ser um número inteiro.");
                            }
                        }
                        else {
                            System.out.println("O mês de nascimento deve ser um número inteiro.");
                        }
                    }
                    else {
                        System.out.println("O ano de nascimento deve ser um número inteiro.");
                    }
                }
                else {
                    System.out.println("O dia da votação deve ser um número inteiro.");
                }
            }
            else {
                System.out.println("O mês da votação deve ser um número inteiro.");
            }
        }
        else {
            System.out.println("O ano da votação deve ser um número inteiro.");
        }

        sc.close();
    }
}
