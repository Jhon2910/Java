import java.util.Scanner;

public class jonathan20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matriz = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int ultimaPos = -1;
        boolean escada = true;

        for (int i = 0; i < N; i++) {
            int pos = -1;
            for (int j = 0; j < M; j++) {
                if (matriz[i][j] != 0) {
                    pos = j;
                    break;
                }
            }

            if (pos == -1) {
                for (int k = i + 1; k < N; k++) {
                    for (int j = 0; j < M; j++) {
                        if (matriz[k][j] != 0) {
                            escada = false;
                        }
                    }
                }
                break;
            } else {
                for (int k = i + 1; k < N; k++) {
                    for (int j = 0; j <= pos; j++) {
                        if (matriz[k][j] != 0) {
                            escada = false;
                        }
                    }
                }
                if (pos <= ultimaPos) {
                    escada = false;
                }
                ultimaPos = pos;
            }

            if (!escada) {
                break;
            }
        }

        if (escada) {
            System.out.println("S\n");
        } else {
            System.out.println("N\n");
        }

        sc.close();
    }
}
