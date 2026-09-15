import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Processo {
        int id, chegada, duracao, restante, inicio = -1, fim = -1;

        Processo(int id, int c, int d) {
            this.id = id;
            this.chegada = c;            
            this.duracao = d;
            this.restante = d;
        }
    }

    public static void main(String[] args) throws Exception {
        File dir = args.length > 0 ? new File(args[0]) : new File(".");

        for (int i = 1; i <= 10; i++) {
            File arq = new File(dir, String.format("TESTE-%02d.txt", i));
            if (!arq.exists()) {
                arq = new File(String.format("TESTE-%02d.txt", i));
            }
            if (!arq.exists()) {
                continue;
            }

            Scanner sc = new Scanner(arq);
            if (!sc.hasNextInt()) {
                sc.close();
                continue;
            }
            int quantum = sc.nextInt();
            List<Processo> procs = new ArrayList<>();
            int id = 0;
            while (sc.hasNextInt()) {
                procs.add(new Processo(id++, sc.nextInt(), sc.nextInt()));
            }
            sc.close();

            procs.sort((a, b) -> a.chegada != b.chegada ? a.chegada - b.chegada : a.id - b.id);

            File outArq = new File(arq.getParentFile(), String.format("TESTE-%02d-RESULTADO.txt", i));
            PrintWriter out = new PrintWriter(outArq);
            out.println(fifo(procs));
            out.println(sjf(procs));
            out.println(srt(procs));
            out.println(rr(procs, quantum));
            out.close();
        }
    }

    static void reset(List<Processo> procs) {
        for (Processo p : procs) {
            p.restante = p.duracao;
            p.inicio = -1;
            p.fim = -1;
        }
    }

    static String metricas(List<Processo> procs) {
        double resp = 0, esp = 0, ret = 0;
        for (Processo p : procs) {
            resp += (p.inicio - p.chegada);
            ret += (p.fim - p.chegada);
            esp += (p.fim - p.chegada - p.duracao);
        }
        int n = procs.size();
        return String.format(new Locale("pt", "BR"), "%.3f %.3f %.3f", resp / n, esp / n, ret / n);
    }

    static String fifo(List<Processo> procs) {
        reset(procs);
        int tempo = 0;
        for (Processo p : procs) {
            if (tempo < p.chegada) {
                tempo = p.chegada;
            }
            p.inicio = tempo;
            tempo += p.duracao;
            p.fim = tempo;
        }
        return metricas(procs);
    }

    static String sjf(List<Processo> procs) {
        reset(procs);
        PriorityQueue<Processo> fila = new PriorityQueue<>((a, b) -> 
            a.duracao != b.duracao ? a.duracao - b.duracao : a.chegada - b.chegada
        );
        int tempo = 0, i = 0, n = procs.size(), concluidos = 0;

        while (concluidos < n) {
            while (i < n && procs.get(i).chegada <= tempo) {
                fila.add(procs.get(i++));
            }
            if (fila.isEmpty()) {
                tempo = procs.get(i).chegada;
                while (i < n && procs.get(i).chegada <= tempo) {
                    fila.add(procs.get(i++));
                }
            }
            Processo p = fila.poll();
            p.inicio = tempo;
            tempo += p.duracao;
            p.fim = tempo;
            concluidos++;
        }
        return metricas(procs);
    }

    static String srt(List<Processo> procs) {
        reset(procs);
        PriorityQueue<Processo> fila = new PriorityQueue<>((a, b) -> 
            a.restante != b.restante ? a.restante - b.restante : a.chegada - b.chegada
        );
        int tempo = 0, i = 0, n = procs.size(), concluidos = 0;
        Processo atual = null;

        while (concluidos < n) {
            while (i < n && procs.get(i).chegada <= tempo) {
                fila.add(procs.get(i++));
            }
            if (atual == null) {
                if (fila.isEmpty()) {
                    tempo = procs.get(i).chegada;
                    while (i < n && procs.get(i).chegada <= tempo) {
                        fila.add(procs.get(i++));
                    }
                }
                atual = fila.poll();
                if (atual.inicio == -1) {
                    atual.inicio = tempo;
                }
            }

            int prox = (i < n) ? procs.get(i).chegada : Integer.MAX_VALUE;
            int exec = Math.min(atual.restante, prox - tempo);
            tempo += exec;
            atual.restante -= exec;

            while (i < n && procs.get(i).chegada <= tempo) {
                fila.add(procs.get(i++));
            }

            if (atual.restante == 0) {
                atual.fim = tempo;
                concluidos++;
                atual = null;
            } else if (!fila.isEmpty() && fila.peek().restante < atual.restante) {
                fila.add(atual);
                atual = fila.poll();
                if (atual.inicio == -1) {
                    atual.inicio = tempo;
                }
            }
        }
        return metricas(procs);
    }

    static String rr(List<Processo> procs, int quantum) {
        reset(procs);
        Queue<Processo> fila = new LinkedList<>();
        int tempo = 0, i = 0, n = procs.size(), concluidos = 0;

        while (i < n && procs.get(i).chegada <= tempo) {
            fila.add(procs.get(i++));
        }

        while (concluidos < n) {
            if (fila.isEmpty()) {
                tempo = procs.get(i).chegada;
                while (i < n && procs.get(i).chegada <= tempo) {
                    fila.add(procs.get(i++));
                }
            }

            Processo p = fila.poll();
            if (p.inicio == -1) {
                p.inicio = tempo;
            }

            int exec = Math.min(quantum, p.restante);
            p.restante -= exec;
            int novoTempo = tempo + exec;

            while (i < n && procs.get(i).chegada < novoTempo) {
                fila.add(procs.get(i++));
            }
            if (p.restante > 0) {
                fila.add(p);
            } else {
                p.fim = novoTempo;
                concluidos++;
            }
            while (i < n && procs.get(i).chegada <= novoTempo) {
                fila.add(procs.get(i++));
            }

            tempo = novoTempo;
        }
        return metricas(procs);
    }
}