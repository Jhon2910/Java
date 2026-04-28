import java.io.*;

public class ConversorMIPS {

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= 10; i++) {

            String numero;
            if (i < 10) {
                numero = "0" + i;
            } else {
                numero = "" + i;
            }

            String entrada = "TESTE-" + numero + ".txt";
            String saida = "TESTE-" + numero + "-RESULTADO.txt";

            File f = new File(entrada);

            if (!f.exists()) {
                System.out.println("Arquivo nao encontrado: " + entrada);
            } else {

                BufferedReader br = new BufferedReader(new FileReader(entrada));
                BufferedWriter bw = new BufferedWriter(new FileWriter(saida));

                String linha;

                while ((linha = br.readLine()) != null) {

                    linha = linha.replace(",", "");
                    linha = linha.replace("(", " ");
                    linha = linha.replace(")", "");

                    String[] p = linha.split("\\s+");

                    String inst = p[0];

                    String resultado = "";

                    // ----------------- Tipo R -------------------
                    // ADD
                    if (inst.equals("add")) {
                        int rd = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int rt = getReg(p[3]);

                        resultado = bin(0, 6) + bin(rs, 5) + bin(rt, 5) + bin(rd, 5) + bin(0, 5) + bin(32, 6);
                    }

                    // SUB
                    else if (inst.equals("sub")) {
                        int rd = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int rt = getReg(p[3]);

                        resultado = bin(0, 6) + bin(rs, 5) + bin(rt, 5) + bin(rd, 5) + bin(0, 5) + bin(34, 6);
                    }

                    // AND
                    else if (inst.equals("and")) {
                        int rd = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int rt = getReg(p[3]);

                        resultado = bin(0, 6) + bin(rs, 5) + bin(rt, 5) + bin(rd, 5) + bin(0, 5) + bin(36, 6);
                    }

                    // OR
                    else if (inst.equals("or")) {
                        int rd = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int rt = getReg(p[3]);

                        resultado = bin(0, 6) + bin(rs, 5) + bin(rt, 5) + bin(rd, 5) + bin(0, 5) + bin(37, 6);
                    }

                    // XOR
                    else if (inst.equals("xor")) {
                        int rd = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int rt = getReg(p[3]);

                        resultado = bin(0, 6) + bin(rs, 5) + bin(rt, 5) + bin(rd, 5) + bin(0, 5) + bin(38, 6);
                    }

                    // SLL
                    else if (inst.equals("sll")) {
                        int rd = getReg(p[1]);
                        int rt = getReg(p[2]);
                        int shamt = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(0, 6) + bin(0, 5) + bin(rt, 5) + bin(rd, 5) + bin(shamt, 5) + bin(0, 6);
                    }

                    // SRL
                    else if (inst.equals("srl")) {
                        int rd = getReg(p[1]);
                        int rt = getReg(p[2]);
                        int shamt = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(0, 6) + bin(0, 5) + bin(rt, 5) + bin(rd, 5) + bin(shamt, 5) + bin(2, 6);
                    }

                    // JR
                    else if (inst.equals("jr")) {
                        int rs = getReg(p[1]);

                        resultado = bin(0, 6) + bin(rs, 5) + bin(0, 5) + bin(0, 5) + bin(0, 5) + bin(8, 6);
                    }

                    // ------------------ Tipo I ---------------------

                    //LB
                    else if (inst.equals("lb")) {
                        int rt = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int
                        int rs = getReg(p[3]);

                        resultado = bin(32, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    //LH
                    else if (inst.equals("lh")) {
                        int rt = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int
                        int rs = getReg(p[3]);

                        resultado = bin(33, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    // LW
                    else if (inst.equals("lw")) {
                        int rt = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int
                        int rs = getReg(p[3]);

                        resultado = bin(35, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }
                    
                    //SB
                    else if (inst.equals("sb")) {
                        int rt = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int
                        int rs = getReg(p[3]);

                        resultado = bin(40, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    //SH
                    else if (inst.equals("sh")) {
                        int rt = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int
                        int rs = getReg(p[3]);

                        resultado = bin(41, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    // SW
                    else if (inst.equals("sw")) {
                        int rt = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int
                        int rs = getReg(p[3]);

                        resultado = bin(43, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    // ADDI
                    else if (inst.equals("addi")) {
                        int rt = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int imm = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(8, 6) + bin(rs, 5) + bin(rt, 5) + bin(imm, 16);
                    }

                    // ANDI
                    else if (inst.equals("andi")) {
                        int rt = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int imm = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(12, 6) + bin(rs, 5) + bin(rt, 5) + bin(imm, 16);
                    }

                    // ORI
                    else if (inst.equals("ori")) {
                        int rt = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int imm = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(13, 6) + bin(rs, 5) + bin(rt, 5) + bin(imm, 16);
                    }

                    // BEQ
                    else if (inst.equals("beq")) {
                        int rs = getReg(p[1]);
                        int rt = getReg(p[2]);
                        int offset = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(4, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    // BNE
                    else if (inst.equals("bne")) {
                        int rs = getReg(p[1]);
                        int rt = getReg(p[2]);
                        int offset = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(5, 6) + bin(rs, 5) + bin(rt, 5) + bin(offset, 16);
                    }

                    // LUI
                    else if (inst.equals("lui") || inst.equals("liu")) {
                        int rt = getReg(p[1]);
                        int imm = Integer.parseInt(p[2]); // Transformar String em int

                        resultado = bin(15, 6) + bin(0, 5) + bin(rt, 5) + bin(imm, 16);
                    }

                    // XORI
                    else if (inst.equals("xori")) {
                        int rt = getReg(p[1]);
                        int rs = getReg(p[2]);
                        int imm = Integer.parseInt(p[3]); // Transformar String em int

                        resultado = bin(14, 6) + bin(rs, 5) + bin(rt, 5) + bin(imm, 16);
                    }

                    // BLEZ
                    else if(inst.equals("blez")) {
                        int rs = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int

                        resultado = bin(6, 6) + bin(rs, 5) + bin(0, 5) + bin(offset, 16);
                    }

                    // BGTZ
                    else if(inst.equals("bgtz")) {
                        int rs = getReg(p[1]);
                        int offset = Integer.parseInt(p[2]); // Transformar String em int

                        resultado = bin(7, 6) + bin(rs, 5) + bin(0, 5) + bin(offset, 16);

                    }

                    // ----------------------TIPO J----------------------

                    // J
                    else if (inst.equals("j")) {
                        int addr = Integer.parseInt(p[1]); // Transformar String em int

                        resultado = bin(2, 6) + bin(addr, 26);
                    }

                    bw.write(resultado);
                    bw.newLine();
                }

                br.close();
                bw.close();

                System.out.println("Gerado: " + saida);
            }
        }
    }

    // ---------- REGISTRADORES ----------
    public static int getReg(String r) { //converter numero string para inteiro

        if (r.equals("$t0"))
            return 8;
        if (r.equals("$t1"))
            return 9;
        if (r.equals("$t2"))
            return 10;
        if (r.equals("$t3"))
            return 11;
        if (r.equals("$t4"))
            return 12;
        if (r.equals("$t5"))
            return 13;
        if (r.equals("$t6"))
            return 14;
        if (r.equals("$t7"))
            return 15;

        if (r.equals("$s0"))
            return 16;
        if (r.equals("$s1"))
            return 17;
        if (r.equals("$s2"))
            return 18;
        if (r.equals("$s3"))
            return 19;
        if (r.equals("$s4"))
            return 20;
        if (r.equals("$s5"))
            return 21;
        if (r.equals("$s6"))
            return 22;
        if (r.equals("$s7"))
            return 23;

        if (r.equals("$r0") || r.equals("$zero"))
            return 0;

        return 0;
    }

    // ---------- BINÁRIO ----------
    public static String bin(int num, int bits) { // converter numero decimal para binario

        String b = Integer.toBinaryString(num); // Converte um número para binário em forma de texto

        while (b.length() < bits) { // completar com 0 
            b = "0" + b;
        }

        if (b.length() > bits) { // cortar se ultrapassar
            b = b.substring(b.length() - bits);
        }

        return b;
    }
}
