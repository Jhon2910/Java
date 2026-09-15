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

        for (int index = 1; index <= 10; index++) {
            File arq = new File(dir, String.format("TESTE-%02d.txt", index));
            if (!arq.exists()) {
                arq = new File(String.format("TESTE-%02d.txt", index));
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

            File outArq = new File(arq.getParentFile(), String.format("TESTE-%02d-RESULTADO.txt", index));
            PrintWriter out = new PrintWriter(outArq);
            out.println(fifo(procs));
            out.println(sjf(procs));
            out.println(srt(procs));
            out.println(rr(procs, quantum));
            out.close();
        }
    }

    static void reset(List<Processo> procs) {
        for (int index = 0; index < procs.size(); index++) {
            Processo p = procs.get(index);
            p.restante = p.duracao;
            p.inicio = -1;
            p.fim = -1;
        }
    }

    static String metricas(List<Processo> procs) {
        double resp = 0, esp = 0, ret = 0;
        for (int index = 0; index < procs.size(); index++) {
            Processo p = procs.get(index);
                resp += (p.inicio - p.chegada);
                ret += (p.fim - p.chegada);
                esp += (p.fim - p.chegada - p.duracao);
        }

        int length = procs.size();
        return String.format(new Locale("pt", "BR"), "%.3f %.3f %.3f", resp / length, esp / length, ret / length);
    }

    static String fifo(List<Processo> procs) {
        reset(procs);
        int tempo = 0;
        for (int index = 0; index < procs.size(); index++) {
            Processo p = procs.get(index);
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
        PriorityQueue<Processo> fila = new PriorityQueue<>(
                (a, b) -> a.duracao != b.duracao ? a.duracao - b.duracao : a.chegada - b.chegada);
        int tempo = 0, index = 0, length = procs.size(), concluidos = 0;

        while (concluidos < length) {
            while (index < length && procs.get(index).chegada <= tempo) {
                fila.add(procs.get(index++));
            }
            if (fila.isEmpty()) {
                tempo = procs.get(index).chegada;
                while (index < length && procs.get(index).chegada <= tempo) {
                    fila.add(procs.get(index++));
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
        PriorityQueue<Processo> fila = new PriorityQueue<>(
                (a, b) -> a.restante != b.restante ? a.restante - b.restante : a.chegada - b.chegada);
        int tempo = 0, index = 0, length = procs.size(), concluidos = 0;
        Processo atual = null;

        while (concluidos < length) {
            while (index < length && procs.get(index).chegada <= tempo) {
                fila.add(procs.get(index++));
            }
            if (atual == null) {
                if (fila.isEmpty()) {
                    tempo = procs.get(index).chegada;
                    while (index < length && procs.get(index).chegada <= tempo) {
                        fila.add(procs.get(index++));
                    }
                }
                atual = fila.poll();
                if (atual.inicio == -1) {
                    atual.inicio = tempo;
                }
            }

            int prox = (index < length) ? procs.get(index).chegada : Integer.MAX_VALUE;
            int exec = Math.min(atual.restante, prox - tempo);
            tempo += exec;
            atual.restante -= exec;

            while (index < length && procs.get(index).chegada <= tempo) {
                fila.add(procs.get(index++));
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
        int tempo = 0, index = 0, length = procs.size(), concluidos = 0;

        while (index < length && procs.get(index).chegada <= tempo) {
            fila.add(procs.get(index++));
        }

        while (concluidos < length) {
            if (fila.isEmpty()) {
                tempo = procs.get(index).chegada;
                while (index < length && procs.get(index).chegada <= tempo) {
                    fila.add(procs.get(index++));
                }
            }

            Processo p = fila.poll();
            if (p.inicio == -1) {
                p.inicio = tempo;
            }

            int exec = Math.min(quantum, p.restante);
            p.restante -= exec;
            int novoTempo = tempo + exec;

            while (index < length && procs.get(index).chegada < novoTempo) {
                fila.add(procs.get(index++));
            }
            if (p.restante > 0) {
                fila.add(p);
            } else {
                p.fim = novoTempo;
                concluidos++;
            }
            while (index < length && procs.get(index).chegada <= novoTempo) {
                fila.add(procs.get(index++));
            }

            tempo = novoTempo;
        }
        return metricas(procs);
    }
}