import java.util.Scanner;

public class jonathan21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nDoconsumidor;
        double KWH;
        double residencial = 0.3;
        double comercial = 0.5;
        double industrial = 0.7;

        while (true) {
            do {
                System.out.print("\nNumero do consumidor: ");
                while (!sc.hasNextInt()) {
                    System.out.print("\nDigite apenas numeros inteiros positivos válidos!");
                    System.out.print("\nNumero do consumidor: ");
                    sc.next();
                }
                nDoconsumidor = sc.nextInt();
            }
            while (nDoconsumidor < 0 || nDoconsumidor > 3);

            if (nDoconsumidor == 0) {
                System.out.println("\nDigite apenas numeros inteiros positivos entre 1 e 3!");
                break;
            }

            System.out.print("\nKWH por mês: ");
            while (!sc.hasNextDouble()) {
                System.out.print("\nDigite apenas numeros validos positivos válidos!");
                System.out.print("\nKKWH por mês: ");
                sc.next();
            }
            KWH = sc.nextDouble();
            sc.nextLine();

            if (KWH < 0) {
                System.out.println("\nDigite apenas numeros positivos!");
                return;
            }

            double custoTotalresidencial = KWH * residencial;
            double custoTotalcomercial = KWH * comercial;
            double custoTotalindustrial = KWH * industrial;
            double totaltodos = custoTotalresidencial + custoTotalcomercial + custoTotalindustrial;
            double mediaResidencialEcomercial = (custoTotalresidencial + custoTotalcomercial) / 2;

            System.out.println("------------------------------------------------");
            if (nDoconsumidor == 1) {
                System.out.printf("\nO custo total para o residencial é: %.2f", custoTotalresidencial);
            } else if (nDoconsumidor == 2) {
                System.out.printf("\nO custo total para o comercial é: %.2f", custoTotalcomercial);
            } else {
                System.out.printf("\nO custo total para o industrial é: %.2f", custoTotalindustrial);
            }
            System.out.println("\n------------------------------------------------");
            System.out.printf("\nO custo total para os três é: %.2f", totaltodos);
            System.out.println("\n------------------------------------------------");
            System.out.printf("\nA média do tipo residencial e do comercial é: %.2f", mediaResidencialEcomercial);
            sc.nextLine();
        }sc.close();
    }
}
