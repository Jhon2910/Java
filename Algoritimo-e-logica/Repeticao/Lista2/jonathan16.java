import java.util.Scanner;

public class jonathan16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binario;
        int decimal = 0;

        System.out.print("Digite um número binário (com N bits): ");
        binario = sc.nextLine();

        int validoFlag = 1;
        int i = 0;
        while (i < binario.length()) {
            int asciiBit = binario.charAt(i);
            if (asciiBit != 48) {
                if (asciiBit != 49) {
                    validoFlag = 0;
                    i = binario.length();
                }
            }
            i++;
        }

        if (validoFlag == 1) {
            int j = 0;
            while (j < binario.length()) {
                int asciiBitChar = binario.charAt(binario.length() - 1 - j);
                if (asciiBitChar == 49) {
                    int p = 1;
                    int k = 0;
                    while (k < j) {
                        p *= 2;
                        k++;
                    }
                    decimal += p;
                }
                j++;
            }

            System.out.println("Número Binário: " + binario);
            System.out.println("Em Decimal: " + decimal);

            String octal = "";
            int tempDecimalOctal = decimal;
            if (tempDecimalOctal == 0) {
                octal = "0";
            } else {
                int l = 0;
                while (tempDecimalOctal > 0) {
                    int resto = tempDecimalOctal % 8;
                    int charRestoAscii = (int) (48 + resto);

                    String tempOctal = "";
                    tempOctal += (char)charRestoAscii;
                    tempOctal += octal;
                    octal = tempOctal;

                    tempDecimalOctal /= 8;
                }
            }
            System.out.println("Em Octal: " + octal);

            String hexadecimal = "";
            int tempDecimalHex = decimal;
            if (tempDecimalHex == 0) {
                hexadecimal = "0";
            } else {
                int m = 0;
                while (tempDecimalHex > 0) {
                    int resto = tempDecimalHex % 16;
                    int charRestoAscii;
                    if (resto < 10) {
                        charRestoAscii = (int) (48 + resto);
                    } else {
                        charRestoAscii = (int) (65 + (resto - 10));
                    }

                    String tempHex = "";
                    tempHex += (char)charRestoAscii;
                    tempHex += hexadecimal;
                    hexadecimal = tempHex;

                    tempDecimalHex /= 16;
                }
            }
            System.out.println("Em Hexadecimal: " + hexadecimal);

        } else {
            System.out.println("Erro: O valor informado não é um número binário válido.");
        }

        sc.close();
    }
}
