package Carro;

public class Carro {
    public String modelo;
    public String cor;
    public String tipo;
    public String placa;

    public Carro() {
    }

    @Override
    public String toString() {
        return "Carro{" + "modelo = " + modelo + ", cor = " + cor + ", tipo = " + tipo + ", placa = " + placa + "}";
    }
}
