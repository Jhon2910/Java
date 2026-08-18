public class Main {
    public static void main(String[] args) {

        int v[] = {5, 2, 4, 6, 1, 3};

        for (int i = 1; i < v.length; i++) {
            int carta = v[i];
            int aux = i - 1;

            while (aux >= 0 && v[aux] > carta) {
                v[aux + 1] = v[aux];
                aux = aux - 1;
            }
            v[aux + 1] = carta;
        }

        for (int i = 0; i <= v.length - 1; i++) {
            System.out.print(" " + v[i] + " ");
        }
    }
}
