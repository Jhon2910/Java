import java.util.Scanner;

public class jonathan6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o Salário em (R$): ");

        if (sc.hasNextDouble()) {
            double salario = sc.nextDouble();
            sc.nextLine();
            double aumento30porcento = salario * 0.30;
            double aumento10porcento = salario * 0.10;

            if(salario < 0){
                System.out.println("Digite um valor acima ou igual a 0!");
            }
            else if (salario >= 0 && salario < 700.00) {
                System.out.printf("O salário reajustado é: R$%.2f\n", salario + aumento30porcento);
            } else {
                System.out.printf("O Salário reajustado é: R$%.2f\n", salario + aumento10porcento);
            }
        }
        else {
            System.out.println("Digite apenas números com até 2 casas decimais!\nexemplo: 500.00");
        }
        sc.close();
    }
}
