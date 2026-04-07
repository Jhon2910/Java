import java.util.Scanner;

public class ex06 {
    static Scanner sc = new Scanner(System.in);

    public static int maior(int n1, int n2) {

        int maior;
        if (n1 > n2){
             maior = n1;
        } else {
            maior = n2;
        }
        return maior;
    }

    public static void main(String[] args) {
        System.out.print("Digite o primeiro numero: ");
        int n1 = sc.nextInt();
        System.out.print("Digite o segundo numero: ");
        int n2 = sc.nextInt();

        System.out.println("O maior numero e: " + maior(n1,n2));
    }
}
