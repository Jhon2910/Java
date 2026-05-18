import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Queue<Aviao> filaPouso1 = new LinkedList<>(); //prateleiras
        Queue<Aviao> filaPouso2 = new LinkedList<>();
        Queue<Aviao> filaPouso3 = new LinkedList<>();
        Queue<Aviao> filaPouso4 = new LinkedList<>();

        Queue<Aviao> filaDecolagem1 = new LinkedList<>();
        Queue<Aviao> filaDecolagem2 = new LinkedList<>();
        Queue<Aviao> filaDecolagem3 = new LinkedList<>();

        int idPouso = 1;
        int idDecolagem = 2;

        int tempo = 0;

        while (true) {
            System.out.println("Digite o tempo que o aviao pode permanecer (de 1 a 20): ");

            if (!sc.hasNextInt()) {
                System.out.println("Digite apenas numeros inteiros! ");
                sc.next();
            } else if (sc.nextInt() < 1 || sc.nextInt() > 20) {
                System.out.println("Digite apenas numeros entre 1 e 20");
                sc.next();
            } else {
                break;
            }
        }

        int n = sc.nextInt();

        while (tempo < n) {

            System.out.println("Tempo: " + tempo);

            int novosPousos = random.nextInt(4);// 0 a 3 aeronaves

            for (int i = 0; i < novosPousos; i++) {

                int combustivel = random.nextInt(n) + 1;

                Aviao aviao = new Aviao(idPouso, "POUSO", combustivel, tempo);

                idPouso += 2;

                Queue<Aviao> menorFila = filaPouso1;

                if (filaPouso2.size() < menorFila.size()) {
                    menorFila = filaPouso2;
                }

                if (filaPouso3.size() < menorFila.size()) {
                    menorFila = filaPouso3;
                }

                if (filaPouso4.size() < menorFila.size()) {
                    menorFila = filaPouso4;
                }

                menorFila.add(aviao);

                System.out.println("Novo avião para pouso: " + aviao);
            }
        }

        while (tempo < n) {

            System.out.println("Tempo: " + tempo);

        }

        while (tempo < n) {

            System.out.println("Tempo: " + tempo);

            int novasDecolagens = random.nextInt(4);// 0 a 3 aeronaves

            for (int i = 0; i < novasDecolagens; i++) {

                Aviao aviao = new Aviao(idDecolagem, "Decolagem", combustivel, tempo);

                int idDecolagem +=2;

                Queue<Aviao> menorFila = filaPouso1;

                if (filaDecolagem2.size() < menorFila.size()) {
                    menorFila = filaDecolagem2;
                }

                if (filaDecolagem3 < menorFila.size()) {
                    menorFila = filaDecolagem3;
                }

                menorFila.add(aviao);

                System.out.println("Novo avião decolando: " + aviao);
            }
        }
    }

}
