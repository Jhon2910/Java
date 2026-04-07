import java.util.Scanner;

public class jonathan3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digíte  o custo de fabrica: ");

        if (sc.hasNextDouble()){
            double custo = sc.nextDouble() ;

            if (custo >= 0 && custo <= 28000){
                System.out.println(custo * 0.05);
            }
            else if(custo > 28000 && custo <= 45000){
                System.out.println(custo + (custo * 0.10) + (custo * 0.15));
            }
            else{
                System.out.println(custo + (custo * 0.15) + (custo * 0.20));
            }
        }
        else {
            System.out.println("Digíte apenas números!");
        }

        sc.close();
    }
}
