import java.util.Scanner;

public class jonathan18{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o código do produto (de 1 a 40): ");
        if (sc.hasNextInt()) {
            int codigoProduto = sc.nextInt();

            System.out.print("Digite a quantidade comprada: ");
            if (sc.hasNextInt()) {
                int quantidade = sc.nextInt();

                double precoUnitario;
                if (codigoProduto >= 1 && codigoProduto <= 10) {
                    precoUnitario = 10.00;
                }
                else if (codigoProduto >= 11 && codigoProduto <= 20) {
                    precoUnitario = 20.00;
                }
                else if (codigoProduto >= 21 && codigoProduto <= 30) {
                    precoUnitario = 30.00;
                }
                else if (codigoProduto >= 31 && codigoProduto <= 40) {
                    precoUnitario = 40.00;
                }
                else {
                    precoUnitario = 0.00;
                }

                if (precoUnitario == 0.00) {
                    System.out.println("Produto com código " + codigoProduto + " não encontrado.");
                }
                else {
                    double totalNota = precoUnitario * quantidade;

                    double percentualDesconto;
                    if (totalNota <= 250) {
                        percentualDesconto = 0.05;
                    }
                    else if (totalNota > 250 && totalNota <= 500) {
                        percentualDesconto = 0.10;
                    }
                    else {
                        percentualDesconto = 0.15;
                    }

                    double valorDesconto = totalNota * percentualDesconto;
                    double precoFinal = totalNota - valorDesconto;
                    
                    System.out.printf("Preço unitário do produto: R$%.2f%n", precoUnitario);
                    System.out.printf("Preço total da nota: R$%.2f%n", totalNota);
                    System.out.printf("Valor do desconto (%.0f%%): R$%.2f%n", percentualDesconto * 100, valorDesconto);
                    System.out.printf("Preço final ao consumidor após desconto: R$%.2f%n", precoFinal);
                }
            }
            else {
                System.out.println("Digite um número inteiro.");
            }
        }
        else {
            System.out.println("Digite um número inteiro.");
        }

        sc.close();
    }
}
