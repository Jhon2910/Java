import java.util.Scanner;

public class jonathan17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de flechas:");
        while (!sc.hasNextInt()){
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            System.out.print("Digite a quantidade de flechas:");
            sc.next();
        }
        int quantidadeDeFlechas = sc.nextInt();

        int[] distanciasQuadradasDasFlechas = new int[quantidadeDeFlechas];
        int penalidadeTotal = 0;

        for (int i = 0; i < quantidadeDeFlechas; i++) {

            int coordenadaX = sc.nextInt();
            int coordenadaY = sc.nextInt();

            int distanciaQuadradaAtual = (coordenadaX * coordenadaX) + (coordenadaY * coordenadaY);
            int penalidadeDaFlechaAtual = 0;

            for (int j = 0; j < i; j++) {
                if (distanciasQuadradasDasFlechas[j] <= distanciaQuadradaAtual) {
                    penalidadeDaFlechaAtual++;
                }
            }

            penalidadeTotal += penalidadeDaFlechaAtual;

            distanciasQuadradasDasFlechas[i] = distanciaQuadradaAtual;
        }

        System.out.println(penalidadeTotal);
        sc.close();
    }
}
