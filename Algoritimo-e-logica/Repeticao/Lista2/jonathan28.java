import java.util.Scanner;

public class jonathan28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int voto;
        int cadidatoA = 0;
        int cadidatoB = 0;
        int cadidatoC = 0;
        int cadidatoD = 0;
        int nulo = 0;
        int branco = 0;

        while (true) {


            System.out.println("\n--------------------------");
            System.out.println("Aperte 0 para parar!");
            System.out.println("1 para candidato A");
            System.out.println("2 para candidato B");
            System.out.println("3 para candidato C");
            System.out.println("4 para candidato D");
            System.out.println("5 para voto nulo");
            System.out.println("Outros valores para voto em branco");
            System.out.println("--------------------------");

            System.out.print("Digite um numero para votar e depois precione enter: ");
            while (!sc.hasNextInt()) {
                System.out.println("Digite apenas numeros inteiros!");
                System.out.print("Digite um numero para votar e depois precione enter: ");
                sc.next();
            }
            voto = sc.nextInt();

            if (voto == 0) {

                System.out.println("Resultado:");

                System.out.printf("\nO candidato A tem: %d votos!", cadidatoA);
                System.out.printf("\nO candidato B tem: %d votos!", cadidatoB);
                System.out.printf("\nO candidato C tem: %d votos!", cadidatoC);
                System.out.printf("\nO candidato D tem: %d votos!", cadidatoD);
                System.out.printf("\nnulo sao: %d votos!", nulo);
                System.out.printf("\nEm branco sao: %d votos!", branco);

                return;
            } else if (voto == 1) {
                System.out.println("Voce votou em candidato A!");
                cadidatoA++;
            } else if (voto == 2) {
                System.out.println("Voce votou em candidato B!");
                cadidatoB++;
            } else if (voto == 3) {
                System.out.println("Voce votou em candidato C!");
                cadidatoC++;
            } else if (voto == 4) {
                System.out.println("Voce votou em candidato D!");
                cadidatoD++;
            } else if (voto == 5) {
                System.out.println("Voce votou nulo!");
                nulo++;
            } else {
                System.out.println("Voce votou em branco");
                branco++;
            }

        }

    }
}
