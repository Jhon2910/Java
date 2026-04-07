import java.util.Scanner;

public class jonathan19 {
    static int L, C;
    static char[][] mapa;
    static boolean[][] visitado;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        mapa = new char[L][C];
        visitado = new boolean[L][C];

        int inicioLinha = -1, inicioColuna = -1;

        for (int i = 0; i < L; i++) {
            String linha = sc.next();
            for (int j = 0; j < C; j++) {
                mapa[i][j] = linha.charAt(j);
                if (mapa[i][j] == 'o') {
                    inicioLinha = i;
                    inicioColuna = j;
                }
            }
        }

        int[] resultado = busca(inicioLinha, inicioColuna);
        System.out.printf("%d %d\n", resultado[0] + 1, resultado[1] + 1);
        sc.close();
    }

    static int[] busca(int i, int j) {
        visitado[i][j] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < L && nj >= 0 && nj < C) {
                if ((mapa[ni][nj] == 'H') && !visitado[ni][nj]) {
                    return busca(ni, nj);
                }
            }
        }

        return new int[]{i, j};
    }
}
