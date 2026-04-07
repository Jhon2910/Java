import java.util.Scanner;

public class jonathan20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double A = 500000;
        double natalidadeA = 0.03;
        double B = 700000;
        double natalidadeB = 0.02;
        int ano = 2015;

        while (A <= B) {
            A = A * natalidadeA + A;
            B = B * natalidadeB + B;
            ano ++;
        }

        System.out.printf("O ano que o pais A ultrapassa o B e: %d",ano);
    }
}
