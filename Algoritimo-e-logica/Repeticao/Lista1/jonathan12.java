import java.util.Scanner;

public class jonathan {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        String cidade;
        int veiculos;
        int acidentes;
        int i;
        double maiorAcidentes = Double.MIN_VALUE;
        double menorAcidentes = Double.MAX_VALUE;
        String nomemaior = " ";
        String nomemenor = " ";
        int somaacidentes = 0;
        int somaveiculos = 0;
        double mediaacidentes = 0;

        for (i = 1; i <= 5; i++) {
            System.out.printf("\nNome da cidade %d: ", i);
            cidade = sc.nextLine();
            while (!cidade.matches("[a-zA-Z]+")) {
                System.out.print("\nTente novamente,Digite apesnas letras validas: ");
                cidade = sc.nextLine();
            }

            System.out.print("Numero de veiculos: ");
            while (!sc.hasNextInt()) {
                System.out.print("\nTente novamente,digite apenas numeros inteiros: ");
                sc.next();
            }
            veiculos = sc.nextInt();

            System.out.print("Numero de acidentes: ");
            while (!sc.hasNextInt()) {
                System.out.print("\nTente novamente,digite apenas numeros inteiros: ");
                sc.next();
            }
            acidentes = sc.nextInt();
            sc.nextLine();

            if (acidentes > maiorAcidentes) {
                maiorAcidentes = acidentes;
                nomemaior = cidade;

            }
            if (acidentes < menorAcidentes) {
                menorAcidentes = acidentes;
                nomemenor = cidade;
            }

            if (veiculos < 200) {
                mediaacidentes = (double)somaacidentes / i;
            }

            somaacidentes += acidentes;
            somaveiculos += veiculos;

            sc.nextLine();


        }
        double razao = (double)somaacidentes/somaveiculos;
        double mediaveiculos = (double) somaveiculos / i;

        System.out.printf("\nO maior indice de acidentes e %.2f da cidade %s", maiorAcidentes, nomemaior);
        System.out.printf("\nO menor indice de acidentes e %.2f da cidade %s", menorAcidentes, nomemenor);
        System.out.printf("\nA razao entre os acidentes e os veiculos e: %.2f", razao);
        System.out.printf("\nA media de acidentes nas cidades com menos de 200 veiculos e: %.2f",mediaacidentes);
        System.out.printf("\nA media de veiculos e: %.2f ",mediaveiculos);

        sc.close();
    }
}
