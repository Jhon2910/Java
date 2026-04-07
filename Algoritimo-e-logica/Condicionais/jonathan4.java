import java.util.Scanner;

public class jonathan4 {
    public static void main(String[]args){
        double num1,num2, rest;
        char op;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite dois numeros:");

        if (sc.hasNextDouble()){

        num1 = sc.nextDouble();
        num2 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Menu:\n+ :Soma\n- :Subtração\n* :Multiplicação\n/ :Divisão\nEscolha:");
        op = sc.nextLine().charAt(0);
        switch (op){
            case '+':
                rest = num1+num2;
                System.out.println("soma = \n"+ rest);
                break;
            case '-':
                rest = num1-num2;
                System.out.println("subtração =  \n"+ rest);
                break;
            case '*':
                rest = num1*num2;
                System.out.println("multiplicação = \n"+ rest);
                break;
            case '/':
                if (num2==0){
                    System.out.print("O denominador não pode ser 0");
                }
                else {
                    rest = num1/num2;
                    System.out.println("divisão = \n"+ rest);
                }
                break;
            default:
                System.out.print("operação inválida!");
        }
        }
        else {
            System.out.println("Digite apenas números!");
        }
        sc.close();
    }
}
