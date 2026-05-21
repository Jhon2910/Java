import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Queue<Aviao> filaPouso1 = new LinkedList<>(); // prateleiras
        Queue<Aviao> filaPouso2 = new LinkedList<>();
        Queue<Aviao> filaPouso3 = new LinkedList<>();
        Queue<Aviao> filaPouso4 = new LinkedList<>();

        Queue<Aviao> filaDecolagem1 = new LinkedList<>();
        Queue<Aviao> filaDecolagem2 = new LinkedList<>();
        Queue<Aviao> filaDecolagem3 = new LinkedList<>();

        int idPouso = 1;
        int idDecolagem = 2;

        int tempo = 0;

        int entrada = random.nextInt(20 + 1);


        //Pousos

        while (tempo < entrada) {

            System.out.println("Tempo: " + tempo);

            int novosPousos = random.nextInt(4);// 0 a 3 aeronaves

            for (int i = 0; i < novosPousos; i++) {

                int combustivel = random.nextInt(entrada) + 1;

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


        //Decolagens
       while (tempo < entrada) {
    
            int combustivel = random.nextInt(20) + 1; 

            System.out.println("Tempo: " + tempo);

            int novasDecolagens = random.nextInt(4);

            for (int j = 0; j < novasDecolagens; j++) {

            Aviao aviao = new Aviao(idDecolagem, "Decolagem", combustivel, tempo);
            idDecolagem += 2;
        
            Queue<Aviao> menorFila = filaDecolagem1;

            if (filaDecolagem2.size() < menorFila.size()) {
            menorFila = filaDecolagem2;
            }

            if (filaDecolagem3.size() < menorFila.size()) {
            menorFila = filaDecolagem3;
            }

            menorFila.add(aviao);
            }
            tempo++; 
        }
    }
}
