import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    
        int[] v1 = {3, 2, 56, 32, 10};
        int[] v2 = {3, 2, 56, 32, 10};
        int[] v3 = {3, 2, 56, 32, 10};

        System.out.println("Vetor original: [3, 2, 56, 32, 10]\n");

        Ordenacao.bubblesort(v1);
        System.out.println("Bubble Sort: " + Arrays.toString(v1));

        Ordenacao.cocktailshakersort(v2);
        System.out.println("Cocktail Shaker Sort: " + Arrays.toString(v2));

        Ordenacao.combsort(v3);
        System.out.println("Comb Sort: " + Arrays.toString(v3));
    }

   
    static class Ordenacao { 

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
                gap = (int)(gap / 1.3);
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
    }
}
