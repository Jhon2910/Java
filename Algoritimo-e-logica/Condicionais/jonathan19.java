import java.util.Scanner;

public class jonathan19 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o salário base(R$): ");
        System.out.print("Digite o tempo de serviço(anos): ");

       if (sc.hasNextDouble()){
        double SalarioBase = sc.nextDouble();
        double tempo = sc.nextDouble();

            if (SalarioBase < 200){
                double imposto=0;
            }
            else if (SalarioBase >= 200 && SalarioBase <= 450) {
                double imposto=0.03;
            }
            else if (SalarioBase > 450 && SalarioBase < 700) {
                double imposto = 0.08 ;
            }
            else {
                double imposto = 0.12 ;
            }

            if (SalarioBase > 500){
                if (tempo<3){
                    double gratificacao = 0.20 * SalarioBase ;
                }
                else {
                    double gratificacao = 0.30 * SalarioBase ;
                }
            }
            else {
                if (tempo<3){
                    double gratificacao = 0.23 * SalarioBase;
                }
                else if (tempo > 3 && tempo < 6){
                    double gratificacao = 0.35;
                }
                else {
                    double gratificacao = 0.33 ;
                }
            }
           
       }
       else {
           System.out.println("Digite apenas números!");
       }
       sc.close();
    }
}
