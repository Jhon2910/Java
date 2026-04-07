import java.util.Scanner;

public class jonathan14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,n1;
        int fatorial;

        int finalizar;

        while (true) {
            System.out.print("Para finalizar digite 0 ou qualquer outro numero para continuar: ");
            while (!sc.hasNextInt()) {
                System.out.println("Digite apenas numeros inteiros!");
                System.out.print("Para finalizar digite 0 ou qualquer outro numero para continuar: ");
                sc.next();
            }
            finalizar = sc.nextInt();

            if (finalizar == 0) {
                System.out.println("Finalizando!");
                return;
            }

            System.out.print("\nDigite um valor para saber o fatorial: ");
            while (!sc.hasNextInt()){
                System.out.print("\nValor invalido, tente novamente!");
                System.out.print("\nDigite um valor para saber o fatorial: ");
                sc.next();
            }

            n = sc.nextInt();
            sc.nextLine();
            n1 = n;
            fatorial = 1;

            if ( n >= 0 ) {
                if (n == 0) {
                    System.out.printf("\nO fatorial de %d e igaual a: 1",n);
                }
                else {
                    while (n > 1) {
                        fatorial *= n;
                        n--;
                    }
                    System.out.printf("\nO fatorial de %d e igaual a: %d",n1,fatorial);
                }
            }
            else {
                System.out.print("\nDigite um valor maior ou igaul a 0!");
            } sc.close();
        }
       
    }
}
