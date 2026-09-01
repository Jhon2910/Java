import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] v = {3, 2, 56, 32, 10};


        System.out.println("Vetor original: [3, 2, 56, 32, 10]\n");

       /* Ordenacao.bubblesort(v);
        System.out.println("Bubble Sort: " + Arrays.toString(v));

        Ordenacao.cocktailshakersort(v);
        System.out.println("Cocktail Shaker Sort: " + Arrays.toString(v));

        Ordenacao.combsort(v);
        System.out.println("Comb Sort: " + Arrays.toString(v));

        Ordenacao.InsertionSort(v);
        System.out.println("Insertion Sort: " + Arrays.toString(v));

        Ordenacao.SelectionSort(v);
        System.out.println("Selection Sort: " + Arrays.toString(v));

        Ordenacao.MergeSort(v);
        System.out.println("Merge Sort; " + Arrays.toString(v));
    }
    */

    class Ordenacao {/*
        public static void bubblesort(int[] v) {
            for (int i = 0; i < v.length - 1; i++) {
                for (int j = 0; j < v.length - i - 1; j++) {
                    if (v[j] > v[j + 1]) {
                        int aux = v[j];
                        v[j] = v[j + 1];
                        v[j + 1] = aux;
                    }
                }
            }
        }

        public static void cocktailshakersort(int[] v) {
            boolean trocou = true;
            int primeiro = 0;
            int ultimo = v.length - 1;

            while (trocou) {
                trocou = false;

                for (int i = primeiro; i < ultimo; i++) {
                    if (v[i] > v[i + 1]) {
                        int temp = v[i];
                        v[i] = v[i + 1];
                        v[i + 1] = temp;
                        trocou = true;
                    }
                }

                if (!trocou) break;

                trocou = false;
                ultimo--;

                for (int i = ultimo - 1; i >= primeiro; i--) {
                    if (v[i] > v[i + 1]) {
                        int temp = v[i];
                        v[i] = v[i + 1];
                        v[i + 1] = temp;
                        trocou = true;
                    }
                }
                primeiro++;
            }
        }

        public static void combsort(int[] v) {
            int gap = v.length;
            boolean trocou = true;
            while (gap > 1 || trocou) {
                gap = (int) (gap / 1.3);
                if (gap < 1) {
                    gap = 1;
                }

                trocou = false;
                for (int i = 0; i < v.length - gap; i++) {
                    if (v[i] > v[i + gap]) {
                        int aux = v[i];
                        v[i] = v[i + gap];
                        v[i + gap] = aux;
                        trocou = true;
                    }
                }
            }
        }

        public static void InsertionSort(int[] v) {
            for (int i = 1; i < v.length; i++) {
                int carta = v[i];
                int aux = i - 1;

                while (aux >= 0 && v[aux] > carta) {
                    v[aux + 1] = v[aux];
                    aux = aux - 1;
                }
                v[aux + 1] = carta;
            }
        }

        public static void SelectionSort(int[] v) {
            for (int i = 0; i < v.length - 1; i++) {
                int indiceMenor = i;
                for (int j = i + 1; j < v.length; j++) {
                    if (v[j] < v[indiceMenor]) {
                        indiceMenor = j;
                    }
                }
                int aux = v[indiceMenor];
                v[indiceMenor] = v[i];
                v[i] = aux;
            }

        }
*/
        public static void MergeSort(int[] v) {

            int meio = v.length / 2;
            int[] e = new int[meio];
            int[] d = new int[v.length - meio];

            for (int i = 0; i < meio; i++) {
                e[i] = v[i];
            }

            for (int i = meio; i < v.length; i++) {
                d[i - meio] = v[i];
            }

            int i = 0;
            int k = 0;
            int j = 0;

            while (i < e.length && j < d.length) {
                if (e[i] <= d[j]) {
                    v[k++] = e[i++];
                }
                else {
                    v[k++] = d[j++];
                }
            }
            while (i < e.length) {
                v[k++] = e[i++];
            }
            while (j < d.length) {
                v[k++] = d[j++];
            }

        }
    }
}}
