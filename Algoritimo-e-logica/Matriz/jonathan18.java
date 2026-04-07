import java.util.Scanner;

public class jonathan18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dario = 0;
        int xerxes = 0;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int x = sc.nextInt();

            if ((d + 1) % 5 == x || (d + 2) % 5 == x) {
                xerxes++;
            } else {
                dario++;
            }
        }

        if (dario > xerxes) {
            System.out.println("dario\n");
        } else {
            System.out.println("xerxes\n");
        }

        sc.close();
    }
}
