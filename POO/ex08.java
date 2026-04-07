import java.util.Scanner;

public class ex08 {
    static Scanner sc = new Scanner(System.in);

    public static int fat(int n) {
        int fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }

    public static void main(String[] args) {

        System.out.println("Digite o fatorial: ");
        int n = sc.nextInt();

        System.out.println(fat(n));

    }
}
