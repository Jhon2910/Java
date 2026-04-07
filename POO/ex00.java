import java.util.Scanner;

public class ex001 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n;

        System.out.print("Digite um numero de 1 a 12 para saber o mes: ");
        if (!sc.hasNextInt()) {
            System.out.print("Erro!");
            return;
        }
        n = sc.nextInt();

        imprimir(n);
    }

    public static void imprimir(int n){

        if (n < 1 || n > 12){
            System.out.print("Erro!");
        }
        else {
            if (n == 1){
                System.out.print("Janeiro");
            } else if (n == 2) {
                System.out.print("Fevereiro");
            }
            else if (n == 3) {
                System.out.print("marco");
            }
            else if (n == 4) {
                System.out.print("abril");
            }
            else if (n == 5) {
                System.out.print("maio");
            }
            else if (n == 6) {
                System.out.print("junho");
            }
            else if (n == 7) {
                System.out.print("julho");
            }else if (n == 8) {
                System.out.print("agosto");
            }else if (n == 9) {
                System.out.print("setembro");
            }else if (n == 10) {
                System.out.print("outubro");
            }
            else if (n == 11) {
                System.out.print("novembro");
            }
            else {
                System.out.print("dezembro");
            }
        }
    }
}
