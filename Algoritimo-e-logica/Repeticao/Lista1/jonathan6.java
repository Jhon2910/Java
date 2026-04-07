import java.util.Scanner;

public class jonathan6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o numero final : ");

        int num = sc.nextInt();
        int soma = 0;
        int n = 1;

        while (n <= num){
            soma = soma + n;
            n++;
        }

        double media = (double) soma /num;

        System.out.println("A soma de "+ num +" primeiros positivos e: "+soma);
        System.out.println("A media de " +num+ " primeiros numeros positivos e: "+ media);
        sc.close();
    }
}
