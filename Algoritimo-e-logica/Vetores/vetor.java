import java.util.Scanner;

public class vetor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double soma = 0;

        //tipo[] nomeDaVariarel = new tipo[];

        double[] nota = new double[5];

        for (int i = 0; i < 5;i++) {
            System.out.printf("Digite o valor da posição %d do vetor: ",(i+1));
            nota[i] = sc.nextDouble();
            soma  =+ nota[i];
        }
        double media = soma/5;

        System.out.print("[");
        for (int i= 0 ;i < 5;i++){
            if (nota[i] > media){
                System.out.println(nota[i] + " acima");
            }
        }
        System.out.print("]");
    }
}
