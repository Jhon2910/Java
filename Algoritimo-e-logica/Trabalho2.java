
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Trabalho2{

    // Guarda os dados de cada acesso à memória
    static class Referencia {
        long pagina;
        long tempo;
        char tipo;

        Referencia(long pagina, long tempo, char tipo) {
            this.pagina = pagina;
            this.tempo = tempo;
            this.tipo = tipo;
        }
    }

    // Procura uma página na memória
    // Retorna a posição ou -1 se não encontrar
    static int buscar(long[] memoria, long pagina) {

        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i] == pagina) {
                return i;
            }
        }

        return -1;
    }

    // Cria uma memória inicialmente vazia
    static long[] criarMemoria(int m) {

        long[] memoria = new long[m];

        Arrays.fill(memoria, -1);

        return memoria;
    }


    // ==================================================
    // 1. ALGORITMO ÓTIMO
    // ==================================================

    static int executarOtimo(int m, List<Referencia> lista) {

        long[] memoria = criarMemoria(m);

        int faltas = 0;

        // Guarda as posições futuras de cada página
        Map<Long, Queue<Integer>> proximosUsos = new HashMap<>();

        // Pré-processa todas as referências
        for (int i = 0; i < lista.size(); i++) {

            long pagina = lista.get(i).pagina;

            proximosUsos
                .computeIfAbsent(pagina, k -> new ArrayDeque<>())
                .add(i);
        }

        // Percorre todos os acessos
        for (int i = 0; i < lista.size(); i++) {

            long pagina = lista.get(i).pagina;

            // Remove a ocorrência atual da fila
            Queue<Integer> filaAtual = proximosUsos.get(pagina);
            filaAtual.poll();

            // Se a página já estiver na memória, continua
            if (buscar(memoria, pagina) != -1) {
                continue;
            }

            // Ocorreu uma falta de página
            faltas++;

            int vitima = -1;

            // Procura uma moldura vazia
            for (int j = 0; j < m; j++) {

                if (memoria[j] == -1) {
                    vitima = j;
                    break;
                }
            }

            // Se a memória estiver cheia, procura a página
            // que será utilizada mais distante no futuro
            if (vitima == -1) {

                int maiorDistancia = -1;

                for (int j = 0; j < m; j++) {

                    Queue<Integer> fila =
                        proximosUsos.get(memoria[j]);

                    // Se não houver uso futuro, considera infinito
                    int proximoUso =
                        (fila == null || fila.isEmpty())
                        ? Integer.MAX_VALUE
                        : fila.peek();

                    // Escolhe a página com uso mais distante
                    if (proximoUso > maiorDistancia) {
                        maiorDistancia = proximoUso;
                        vitima = j;
                    }
                }
            }

            // Coloca a nova página na memória
            memoria[vitima] = pagina;
        }

        return faltas;
    }


    // ==================================================
    // 2. ALGORITMO NRU
    // ==================================================

    static int executarNRU(int m, long ciclo,
                           List<Referencia> lista) {

        long[] memoria = criarMemoria(m);

        // Bit R: indica se a página foi utilizada recentemente
        boolean[] r = new boolean[m];

        // Bit M: indica se a página foi modificada
        boolean[] mod = new boolean[m];

        int faltas = 0;

        // Momento do próximo reset do bit R
        long proximoReset = ciclo;

        for (Referencia ref : lista) {

            // Reseta os bits R quando chega o momento
            while (ref.tempo >= proximoReset) {

                Arrays.fill(r, false);

                proximoReset += ciclo;
            }

            int pos = buscar(memoria, ref.pagina);

            // Verifica se a página já está na memória
            if (pos != -1) {

                // Marca a página como utilizada
                r[pos] = true;

                // Se for escrita, marca como modificada
                if (ref.tipo == 'W') {
                    mod[pos] = true;
                }

                continue;
            }

            // Ocorreu uma falta de página
            faltas++;

            int vitima = -1;

            // Procura uma moldura vazia
            for (int j = 0; j < m; j++) {

                if (memoria[j] == -1) {
                    vitima = j;
                    break;
                }
            }

            // Se não houver espaço vazio, escolhe pela classe NRU
            if (vitima == -1) {

                int menorClasse = 4;

                for (int j = 0; j < m; j++) {

                    int classe;

                    // Calcula a classe da página
                    if (!r[j] && !mod[j]) {
                        classe = 0;
                    }
                    else if (!r[j] && mod[j]) {
                        classe = 1;
                    }
                    else if (r[j] && !mod[j]) {
                        classe = 2;
                    }
                    else {
                        classe = 3;
                    }

                    // Escolhe a primeira página da menor classe
                    if (classe < menorClasse) {
                        menorClasse = classe;
                        vitima = j;
                    }
                }
            }

            // Substitui a página escolhida
            memoria[vitima] = ref.pagina;

            // A nova página acabou de ser acessada
            r[vitima] = true;

            // Registra se o acesso foi uma escrita
            mod[vitima] = (ref.tipo == 'W');
        }

        return faltas;
    }


    // ==================================================
    // 3. ALGORITMO DO RELÓGIO
    // ==================================================

    static int executarRelogio(int m, List<Referencia> lista) {

        long[] memoria = criarMemoria(m);

        // Bit R de cada página
        boolean[] r = new boolean[m];

        int faltas = 0;

        // Posição atual do ponteiro
        int ponteiro = 0;

        for (Referencia ref : lista) {

            int pos = buscar(memoria, ref.pagina);

            // Se a página já estiver na memória
            if (pos != -1) {

                // Dá uma segunda chance à página
                r[pos] = true;

                continue;
            }

            // Ocorreu uma falta de página
            faltas++;

            // Procura uma moldura vazia ou uma página com R = false
            while (memoria[ponteiro] != -1 && r[ponteiro]) {

                // Retira a segunda chance da página
                r[ponteiro] = false;

                // Avança o ponteiro circular
                ponteiro = (ponteiro + 1) % m;
            }

            // Coloca a nova página na memória
            memoria[ponteiro] = ref.pagina;

            // A nova página entra com R = false
            r[ponteiro] = false;

            // Avança o ponteiro
            ponteiro = (ponteiro + 1) % m;
        }

        return faltas;
    }


    // ==================================================
    // 4. ALGORITMO WSCLOCK
    // ==================================================

    static int executarWSClock(int m, long tau,
                               List<Referencia> lista) {

        long[] memoria = criarMemoria(m);

        // Bit R: indica uso recente
        boolean[] r = new boolean[m];

        // Bit M: indica se a página foi modificada
        boolean[] mod = new boolean[m];

        // Guarda o momento do último uso da página
        long[] ultimoUso = new long[m];

        int faltas = 0;

        // Posição atual do ponteiro circular
        int ponteiro = 0;

        for (Referencia ref : lista) {

            int pos = buscar(memoria, ref.pagina);

            // Se a página já estiver na memória
            if (pos != -1) {

                r[pos] = true;

                // Atualiza o último uso
                ultimoUso[pos] = ref.tempo;

                // Marca como modificada se for escrita
                if (ref.tipo == 'W') {
                    mod[pos] = true;
                }

                continue;
            }

            // Ocorreu uma falta de página
            faltas++;

            int vitima = -1;

            // Primeiro procura uma moldura vazia
            for (int i = 0; i < m; i++) {

                int atual = (ponteiro + i) % m;

                if (memoria[atual] == -1) {
                    vitima = atual;
                    break;
                }
            }

            // Se não houver espaço vazio, executa o WSClock
            if (vitima == -1) {

                // Percorre todas as molduras
                for (int i = 0; i < m; i++) {

                    int atual = ponteiro;

                    // Se R = true, a página recebe uma segunda chance
                    if (r[atual]) {

                        // Limpa o bit R
                        r[atual] = false;

                        // Atualiza o último uso
                        ultimoUso[atual] = ref.tempo;
                    }

                    else {

                        // Calcula a idade da página
                        long idade = ref.tempo - ultimoUso[atual];

                        // Verifica se a página está fora da janela de trabalho
                        if (idade > tau) {

                            // Se não foi modificada, pode ser substituída
                            if (!mod[atual]) {

                                vitima = atual;
                                break;
                            }

                            // Se foi modificada, simula sua gravação
                            // em disco e deixa o bit M como false
                            else {

                                mod[atual] = false;
                            }
                        }
                    }

                    // Avança o ponteiro circular
                    ponteiro = (ponteiro + 1) % m;
                }

                // Se nenhuma vítima foi encontrada
                if (vitima == -1) {

                    // Escolhe a página mais antiga
                    vitima = 0;

                    for (int j = 1; j < m; j++) {

                        if (ultimoUso[j] < ultimoUso[vitima]) {
                            vitima = j;
                        }
                    }

                    // Simula a gravação caso esteja modificada
                    if (mod[vitima]) {
                        mod[vitima] = false;
                    }
                }
            }

            // Substitui a página escolhida
            memoria[vitima] = ref.pagina;

            // A nova página acabou de ser acessada
            r[vitima] = true;

            // Registra se houve escrita
            mod[vitima] = (ref.tipo == 'W');

            // Registra o momento do acesso
            ultimoUso[vitima] = ref.tempo;

            // O próximo ciclo começa depois da vítima
            ponteiro = (vitima + 1) % m;
        }

        return faltas;
    }


    // ==================================================
    // 5. PROGRAMA PRINCIPAL
    // ==================================================

    public static void main(String[] args) {

        // Define a pasta onde estão os arquivos
        Path pasta;

        if (args.length > 0) {
            pasta = Path.of(args[0]);
        }
        else {
            pasta = Path.of(".");
        }

        // Percorre os dez arquivos de teste
        for (int i = 1; i <= 10; i++) {

            String nomeEntrada = String.format(
                "TESTE-%02d.txt", i
            );

            String nomeSaida = String.format(
                "TESTE-%02d-RESULTADO.txt", i
            );

            // Monta o caminho completo dos arquivos
            Path arquivoEntrada = pasta.resolve(nomeEntrada);
            Path arquivoSaida = pasta.resolve(nomeSaida);

            // Verifica se o arquivo existe
            if (!Files.exists(arquivoEntrada)) {

                System.out.println(
                    "Arquivo não encontrado: " + nomeEntrada
                );

                continue;
            }

            try {

                // Lê o conteúdo do arquivo
                String conteudo = Files.readString(arquivoEntrada);

                // Separa os valores por espaços e quebras de linha
                String[] dados = conteudo.trim().split("\\s+");

                // Verifica se o cabeçalho está completo
                if (dados.length < 3) {
                    throw new IllegalArgumentException(
                        "Arquivo sem cabeçalho completo."
                    );
                }

                // Lê o total de páginas
                long totalPaginas = Long.parseLong(dados[0]);

                // Lê a quantidade de molduras como long
                long mLido = Long.parseLong(dados[1]);

                // Lê o ciclo do bit R
                long ciclo = Long.parseLong(dados[2]);

                // Verifica se os valores são válidos
                if (totalPaginas < 1 || mLido < 1 || ciclo < 1) {
                    throw new IllegalArgumentException(
                        "Valores iniciais inválidos."
                    );
                }

                // Verifica se todas as referências estão completas
                if ((dados.length - 3) % 3 != 0) {
                    throw new IllegalArgumentException(
                        "Referências incompletas."
                    );
                }

                // Calcula quantas referências existem
                int quantidadeReferencias = (dados.length - 3) / 3;

                // Não é necessário ter mais molduras do que referências
                int m = (int) Math.min(
                    mLido,
                    Math.max(1, quantidadeReferencias)
                );

                // Lista que armazenará os acessos
                List<Referencia> lista = new ArrayList<>();

                // Lê todas as referências
                for (int j = 3; j < dados.length; j += 3) {

                    long pagina = Long.parseLong(dados[j]);

                    long tempo = Long.parseLong(dados[j + 1]);

                    // Verifica se o tipo possui apenas um caractere
                    if (dados[j + 2].length() != 1) {
                        throw new IllegalArgumentException(
                            "Tipo de acesso inválido."
                        );
                    }

                    char tipo = dados[j + 2].charAt(0);

                    // Verifica os dados do acesso
                    // Não verifica pagina >= totalPaginas
                    if (pagina < 0 ||
                        tempo < 0 ||
                        (tipo != 'R' && tipo != 'W')) {

                        throw new IllegalArgumentException(
                            "Acesso inválido."
                        );
                    }

                    // Adiciona o acesso à lista
                    lista.add(new Referencia(pagina, tempo, tipo));
                }

                // Executa os quatro algoritmos
                int otimo = executarOtimo(m, lista);

                int nru = executarNRU(m, ciclo, lista);

                int relogio = executarRelogio(m, lista);

                // Utiliza o ciclo como valor de tau do WSClock
                int wsclock = executarWSClock(m, ciclo, lista);

                // Organiza os resultados na ordem solicitada
                String resultado =
                    otimo + "\n" +
                    nru + "\n" +
                    relogio + "\n" +
                    wsclock + "\n";

                // Grava o arquivo de resultado na mesma pasta
                Files.writeString(arquivoSaida, resultado);

                // Mostra os resultados no terminal
                System.out.println(
                    "\nArquivo processado: " + nomeEntrada
                );

                System.out.println("Ótimo: " + otimo);
                System.out.println("NRU: " + nru);
                System.out.println("Relógio: " + relogio);
                System.out.println("WSClock: " + wsclock);

            }

            catch (Exception e) {

                System.out.println(
                    "Erro ao processar " + nomeEntrada +
                    ": " + e.getMessage()
                );
            }
        }

        System.out.println("\nSimulação concluída!");
    }
}
