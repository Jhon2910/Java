import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Queue<Aviao> filaPouso1 = new LinkedList<>();
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
            System.out.println("Digite o tempo: ");

            if (!sc.hasNextInt()) {
                System.out.println("Digite apenas numeros inteiros! ");
            } else {
                break;
            }
        }
        sc.nextInt();

        int n = sc.nextInt();

        while (tempo < n) {

            System.out.println("TEMPO: " + tempo);

            int novosPousos = random.nextInt(4);

            for (int i = 0; i < novosPousos; i++) {

                int combustivel = random.nextInt(n) + 1;

                Aviao aviao = new Aviao(
                        idPouso,
                        "POUSO",
                        combustivel,
                        tempo
                );

                idPouso += 2;

                // Escolhe menor fila
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
