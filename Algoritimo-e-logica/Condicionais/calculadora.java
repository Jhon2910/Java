import java.util.Scanner;

public class jonathan3 {
    public static void main(String[]args){
        double num1,num2, rest;
        char op;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite dois numeros: ");
        
            num1 = sc.nextDouble();
            num2 = sc.nextDouble();
            System.out.println("Menu:\n + :soma\n- :subtração\n* :multiplicação\n/ :divisão\nEscolha:");
            op = sc.nextLine().charAt(0);
            switch (op){
                case '+':
                    rest = num1+num2;
                    System.out.println("soma ="+ rest);
                    break;
                case '-':
                    rest = num1-num2;
                    System.out.println("subtrção ="+ rest);
                    break;
                case '*':
                    rest = num1*num2;
                    System.out.println("multiplicação ="+ rest);
                    break;
                case '/':
                    if (num2==0){
                        System.out.print("O denominador não pode ser 0");
                    }
                    else {
                    rest = num1/num2;
                    System.out.println("divisão = "+ rest);
                    }
                    break;
                default:
                    System.out.print("operação inválida!");
            }
        }
}
