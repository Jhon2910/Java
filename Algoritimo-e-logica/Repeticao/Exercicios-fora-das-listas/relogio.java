public class jonathan1 {
    public static void main(String[] args) {

        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {

                    int hora12 = h % 12;
                    if (hora12 == 0) {
                        hora12 = 12;
                    }

                    String periodo = (h < 12) ? "AM" : "PM";

                    System.out.print("\033[H\033[2J");

                    System.out.printf("   %02d:%02d:%02d %s\n", hora12, m, s, periodo);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
