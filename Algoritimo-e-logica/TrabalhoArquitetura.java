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
            String saida = "TESTE-" + numero + "-RESULTADO.txt";

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

    public static int calcularCiclos(ArrayList<String> instrucoes) {

        int ciclos = instrucoes.size() + 4;

        for (int i = 0; i < instrucoes.size() - 1; i++) {

            String atual = instrucoes.get(i);
            String proxima = instrucoes.get(i + 1);

            ciclos += bolhas(atual, proxima);
        }

        return ciclos;
    }

    // Retorna a lista de registradores FONTE lidos por uma instrução.
    // Recebe o array de tokens já com vírgulas/parênteses removidos.
    public static List<String> fontes(String[] tokens) {

        List<String> resultado = new ArrayList<>();

        if (tokens.length == 0) return resultado;

        String op = tokens[0].toLowerCase();

        switch (op) {

            // Tipo R: add/sub/and/or/xor $rd, $rs, $rt  -> fontes: tokens[2], tokens[3]
            case "add":
            case "sub":
            case "and":
            case "or":
            case "xor":
                if (tokens.length > 3) resultado.add(tokens[2]);
                if (tokens.length > 3) resultado.add(tokens[3]);
                break;

            // Shift: sll/srl $rd, $rt, sa  -> fonte: tokens[2] (sa é número)
            case "sll":
            case "srl":
                if (tokens.length > 2) resultado.add(tokens[2]);
                break;

            // Tipo I aritmético/lógico: addi/andi/ori/xori $rt, $rs, imm -> fonte: tokens[2]
            // lui $rt, imm -> sem registrador fonte (imediato apenas)
            case "addi":
            case "andi":
            case "ori":
            case "xori":
                if (tokens.length > 2) resultado.add(tokens[2]);
                break;

            case "lui":
                // lui $rt, imm: sem registrador fonte
                break;

            // Load: lw/lb/lh $rt, offset($rs)
            // Após limpar: tokens[0]=op, tokens[1]=$rt(dest), tokens[2]=offset, tokens[3]=$rs(fonte)
            // Fonte: apenas o registrador base tokens[3]
            case "lw":
            case "lb":
            case "lh":
                if (tokens.length > 3) resultado.add(tokens[3]);
                break;

            // Store: sw/sb/sh $rt, offset($rs)
            // Após limpar: tokens[0]=op, tokens[1]=$rt(valor), tokens[2]=offset, tokens[3]=$rs(base)
            // Fontes: tokens[1] (valor a guardar) e tokens[3] (endereço base)
            // Não tem registrador de destino (escreve na memória)
            case "sw":
            case "sb":
            case "sh":
                if (tokens.length > 1) resultado.add(tokens[1]);
                if (tokens.length > 3) resultado.add(tokens[3]);
                break;

            // Branch: beq/bne $rs, $rt, offset -> fontes: tokens[1], tokens[2]
            case "beq":
            case "bne":
                if (tokens.length > 1) resultado.add(tokens[1]);
                if (tokens.length > 2) resultado.add(tokens[2]);
                break;

            // Branch de 1 operando: blez/bgtz $rs, offset -> fonte: tokens[1]
            case "blez":
            case "bgtz":
                if (tokens.length > 1) resultado.add(tokens[1]);
                break;

            // Jump register: jr $rs -> fonte: tokens[1]
            case "jr":
                if (tokens.length > 1) resultado.add(tokens[1]);
                break;

            // Jump direto: j instr_index -> sem registradores
            case "j":
                break;

            default:
                break;
        }

        return resultado;
    }

    public static int bolhas(String atual, String proxima) {

        atual = limpar(atual);
        proxima = limpar(proxima);

        String[] a = atual.split("\\s+");
        String[] b = proxima.split("\\s+");

        if (a.length == 0 || b.length == 0) return 0;

        String op = a[0].toLowerCase();

        // Load-use hazard: ocorre quando um load (lw/lb/lh) é seguido
        // IMEDIATAMENTE por uma instrução que lê o registrador carregado.
        // Com adiantamento de dados, este é o ÚNICO hazard que ainda exige 1 bolha.
        if (op.equals("lw") || op.equals("lb") || op.equals("lh")) {

            // Registrador de destino do load: tokens[1]
            if (a.length < 2) return 0;
            String destino = a[1];

            // Verifica se o destino do load aparece como FONTE da instrução seguinte
            List<String> fontesDaProxima = fontes(b);

            for (String fonte : fontesDaProxima) {
                if (fonte.equals(destino)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static String limpar(String linha) {

        linha = linha.replace(",", " ");
        linha = linha.replace("(", " ");
        linha = linha.replace(")", " ");

        // Normaliza múltiplos espaços/tabulações em um único espaço
        linha = linha.trim().replaceAll("\\s+", " ");

        return linha;
    }
}
