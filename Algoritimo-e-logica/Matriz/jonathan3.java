import java.util.Scanner;

public class jonathan3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int semana;
        int soma = 0;
        int acima = 0;
        double media;
        int menorDia = Integer.MAX_VALUE;

        System.out.print("Digite o número de semanas: ");
        while (!sc.hasNextInt()) {
            System.out.println("Digite apenas números inteiros.");
            System.out.print("\nDigite o número de semanas: ");
            sc.next();
        }
        semana = sc.nextInt();

        int matriz[][] = new int[semana][7];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Produção do %dº dia: ", j + 1);
                while (!sc.hasNextInt()) {
                    System.out.print("Digite um numero inteiro.");
                    System.out.printf("Produção do %dº dia: ", j + 1);
                    sc.next();
                }
                matriz[i][j] = sc.nextInt();
                soma += matriz[i][j];
            }
        }
        media = (double) soma / (semana * 7);

        int AbaixoMedia[] = new int[semana];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > media) {
                    acima += 1;
                } else {
                    if (matriz[i][j] < menorDia) {
                        if (j < 7) {
                            menorDia = matriz[i][j];
                            AbaixoMedia[i] = j + 1;
                        }
                    }
                }
            }
        }

        relatorio(semana, media, acima, AbaixoMedia);
    }

    public static void relatorio(int semana, double media, int acima, int AbaixoMedia[]) {

        System.out.printf("\nRelatório de produção relativo a %d semanas", semana);
        System.out.println("\n---------------------------------------------------");
        System.out.printf("\nProdução média = %.2f", media);
        System.out.printf("\nNúmero de dias com produção acima da média = %d", acima);
        System.out.println(" ");
        System.out.print("\nIndicação dos dias de mínima produção: ");
        for (int i = 0; i < semana; i++) {
            System.out.printf("\nSemana %d .............................. dia %d", i + 1, AbaixoMedia[i]);
        }
        System.out.print("\n---------------------------------------------------------");
    }
}
