package com.mycompany.tp;

public class Aviao {

        int id;
        String tipo;
        int combustivel;
        int tempoEntrada;

        public Aviao(int id, String tipo, int combustivel, int tempoEntrada) {
            this.id = id;
            this.tipo = tipo;
            this.combustivel = combustivel;
            this.tempoEntrada = tempoEntrada;
        }

        @Override
        public String toString() {
            if (tipo.equals("POUSO")) {
                return "A" + id + "(Comb: " + combustivel + ")";
            }

            return "D" + id;
        }
    }
