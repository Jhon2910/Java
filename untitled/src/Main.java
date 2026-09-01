public class Main {
    public static void main(String[] args) {
        int[] v = {2, 2, 5, 5, 7};
        int resultado = buscaBinaria(5, v);

        System.out.println("Posição encontrada: " + resultado);
    }

    public static int buscaBinaria(int x, int[] v) {
        int inicio = 0;
        int fim = v.length - 1;
        int resultado = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (v[meio] == x) {
                resultado = meio;
                fim = meio - 1;
            } else if (v[meio] < x) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return resultado;
    }
}