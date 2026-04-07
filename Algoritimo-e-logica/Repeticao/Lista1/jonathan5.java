import java.util.Scanner;

public class jonathan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1;

        while (n <= 10){
            int proximo = n+1;
            int soma = n + proximo;
            double media = (double)soma / 2.0 ;
            System.out.println(n + "+" +proximo+ "=" + soma +" ,media = " + media );
            n++;
        }
        sc.close();
    }
}
