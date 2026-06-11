import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= 10; i++) {

            String numero;

            if (i < 10)
                numero = "0" + i;
            else
                numero = "" + i;

            String entrada = "TESTE-" + numero + ".txt";
            String saida   = "TESTE-" + numero + "-RESULTADO.txt";

            File arquivo = new File(entrada);

            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado: " + entrada);
                continue;
            }

            ArrayList<String> instrucoes = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(entrada));
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    instrucoes.add(linha);
                }
            }

            br.close();

            int ciclos = calcularCiclos(instrucoes);

            BufferedWriter bw = new BufferedWriter(new FileWriter(saida));
            bw.write(String.valueOf(ciclos));
            bw.close();

            System.out.println(saida + " -> " + ciclos);
        }
    }

    //------------------------------------------------------------------------
    // Calcula o total de ciclos do pipeline.
    // Base: N instruções = N + 4 ciclos (pipeline de 5 estágios).
    // Para cada par consecutivo, verifica se há load-use hazard e soma +1 bolha se necessário.


    public static int calcularCiclos(ArrayList<String> instrucoes) {

        int ciclos = instrucoes.size() + 4;

        for (int i = 0; i < instrucoes.size() - 1; i++) {
            ciclos += bolhas(instrucoes.get(i), instrucoes.get(i + 1));
        }

        return ciclos;
    }

    //------------------------------------------------------------------------
    // Retorna os registradores FONTE (lidos) de uma instrução.
    // Isso é necessário para não confundir o registrador de DESTINO com uma fonte.
    // Exemplo: lw $t0 → add $t0, $s1, $s2
    //          O $t0 do add é DESTINO, não está sendo lido → sem load-use hazard.


    public static List<String> fontes(String[] tokens) {

        List<String> resultado = new ArrayList<>();
        if (tokens.length == 0) return resultado;

        String op = tokens[0].toLowerCase();

        switch (op) {

            // Tipo R: add/sub/and/or/xor  $rd, $rs, $rt
            //         tokens:              [1]  [2]  [3]
            // Fontes: $rs (tokens[2]) e $rt (tokens[3])
            case "add": case "sub": case "and": case "or": case "xor":
                if (tokens.length > 3) {
                    resultado.add(tokens[2]);
                    resultado.add(tokens[3]);
                }
                break;

            // Shift: sll/srl  $rd, $rt, sa
            //        tokens:   [1]  [2]  [3]
            // Fonte: $rt (tokens[2]); sa é imediato numérico, não registrador
            case "sll": case "srl":
                if (tokens.length > 2) resultado.add(tokens[2]);
                break;

            // Tipo I aritmético/lógico: addi/andi/ori/xori  $rt, $rs, imm
            //                           tokens:               [1]  [2]  [3]
            // Fonte: $rs (tokens[2]); $rt (tokens[1]) é o DESTINO
            case "addi": case "andi": case "ori": case "xori":
                if (tokens.length > 2) resultado.add(tokens[2]);
                break;

            // lui  $rt, imm  — carrega imediato, sem registrador fonte
            case "lui":
                break;

            // Load: lw/lb/lh  $rt,  offset($rs)
            //       tokens:    [1]   [2]    [3]
            // Fonte: apenas $rs (tokens[3]); $rt (tokens[1]) é o DESTINO
            case "lw": case "lb": case "lh":
                if (tokens.length > 3) resultado.add(tokens[3]);
                break;

            // Store: sw/sb/sh  $rt,  offset($rs)
            //        tokens:    [1]   [2]    [3]
            // Fontes: $rt (tokens[1]) — valor a guardar
            //         $rs (tokens[3]) — endereço base
            // Store não tem registrador de destino (escreve na memória)
            case "sw": case "sb": case "sh":
                if (tokens.length > 1) resultado.add(tokens[1]);
                if (tokens.length > 3) resultado.add(tokens[3]);
                break;

            // Branch: beq/bne  $rs, $rt, offset
            //         tokens:   [1]  [2]   [3]
            // Fontes: $rs (tokens[1]) e $rt (tokens[2])
            case "beq": case "bne":
                if (tokens.length > 1) resultado.add(tokens[1]);
                if (tokens.length > 2) resultado.add(tokens[2]);
                break;

            // Branch 1 operando: blez/bgtz  $rs, offset
            //                    tokens:     [1]   [2]
            // Fonte: $rs (tokens[1])
            case "blez": case "bgtz":
                if (tokens.length > 1) resultado.add(tokens[1]);
                break;

            // Jump register: jr  $rs
            //                tokens: [1]
            // Fonte: $rs (tokens[1])
            case "jr":
                if (tokens.length > 1) resultado.add(tokens[1]);
                break;

            // Jump direto: j  instr_index — sem registradores
            case "j":
                break;

            default:
                break;
        }

        return resultado;
    }

    // ---------------------------------------------------------------
    // Verifica se duas instruções consecutivas geram load-use hazard.
    // Com adiantamento, este é o único conflito que ainda exige 1 bolha:
    // ocorre quando um load (lw/lb/lh) é seguido imediatamente por uma
    // instrução que LÊ o registrador carregado.
    // Retorna 1 se houver hazard, 0 caso contrário.
    
    public static int bolhas(String atual, String proxima) {

        atual   = limpar(atual);
        proxima = limpar(proxima);

        String[] a = atual.split("\\s+");
        String[] b = proxima.split("\\s+");

        if (a.length == 0 || b.length == 0) return 0;

        String opAtual = a[0].toLowerCase();

        // Load-use hazard: load seguido imediatamente de instrução que lê o destino
        if (opAtual.equals("lw") || opAtual.equals("lb") || opAtual.equals("lh")) {
            if (a.length >= 2) {
                String destino = a[1];
                for (String fonte : fontes(b)) {
                    if (fonte.equals(destino)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    // ---------------------------------------------------------------
    // Remove vírgulas e parênteses da instrução e normaliza espaços,
   
    public static String limpar(String linha) {
        linha = linha.replace(",", " ");
        linha = linha.replace("(", " ");
        linha = linha.replace(")", " ");
        linha = linha.trim().replaceAll("\\s+", " ");
        return linha;
    }
}
