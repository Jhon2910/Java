package Pessoa;
import Carro.Carro;

public class Pessoa {

    public Carro carro;
    public String nome;
    public int idade;

    public Pessoa() {
    }

    @Override
    public String toString(){
        return "Pessoa {" + " Nome = " + nome + ", Idade = " + idade + " Carro = " + carro + "}";
    }
}
