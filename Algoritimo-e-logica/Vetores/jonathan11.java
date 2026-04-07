import java.util.Scanner;

public class jonathan11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    

        System.out.print("Quantos numeros primos deseja encontrar? ");
        int quantidadeDesejada = sc.nextInt();

        System.out.print("Iniciar a busca a partir de qual numero? ");
        int numeroDePartida = sc.nextInt();

        System.out.println("\nIniciando a busca...");

        int tempoInicial = (int) System.nanoTime();

        int[] primosEncontrados = new int[quantidadeDesejada];
        int quantidadeEncontrada = 0;
        int numeroAtual = numeroDePartida;

        while (quantidadeEncontrada < quantidadeDesejada) {
            boolean ehPrimoDeFato = true;

            if (numeroAtual <= 1) {
                ehPrimoDeFato = false;
            } else {
                for (int divisor = 2; divisor * divisor <= numeroAtual; divisor++) {
                    if (numeroAtual % divisor == 0) {
                        ehPrimoDeFato = false;
                        break;
                    }
                }
            }

            if (ehPrimoDeFato) {
                primosEncontrados[quantidadeEncontrada] = numeroAtual;
                quantidadeEncontrada++;
            }
            numeroAtual++;
        }

        int tempoFinal = (int) System.nanoTime();
        int duracaoEmNanossegundos = tempoFinal - tempoInicial;

        System.out.println("\nBusca finalizada! Os " + quantidadeDesejada + " primos encontrados foram:");

        System.out.print("[");
        for (int i = 0; i < primosEncontrados.length; i++) {
            System.out.print(primosEncontrados[i]);
            if (i < primosEncontrados.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("\nTempo de execucao: " + duracaoEmNanossegundos + " nanossegundos.");

        sc.close();
    }
}
