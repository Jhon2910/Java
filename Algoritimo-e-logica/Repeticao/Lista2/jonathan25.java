import java.util.Scanner;

public class jonathan25{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Verificando se os números de 1 a 5 são perfeitos:");
        
        for (n = 1; n <= 5; n++) {
            int somaDivisores = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    somaDivisores += i;
                }
            }
            if (somaDivisores == n) {
                System.out.printf("\nO número %d é perfeito.", n);
            } else {
                System.out.printf("\nO número %d não é perfeito.", n);
            }
        }
        sc.close();
    }
}
