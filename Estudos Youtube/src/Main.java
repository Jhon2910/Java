import Carro.Carro;
import Pessoa.Pessoa;
import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> carros = new ArrayList<>();
        carros.add("Gol");
        carros.add("Corolla");
        carros.add("Gol");

        System.out.print("Lista: " + carros);

        Set<String> carrosSet = new HashSet<>();
        carrosSet.add("Gol");
        carrosSet.add("Corolla");
        carrosSet.add("Gol");

        System.out.printf("\nSet: %s\n", carrosSet);

        Map<String, Carro> carrosMap = new HashMap<>();
        carrosMap.put("Gol", new Carro());

        System.out.print(carrosMap.put("Gol", new Carro()));

        System.out.println("Adicione o modelo, cor, tipo e placa");

        List<Carro> listaDeCarros = new ArrayList<>();
        String resposta = "sim";

        while (resposta.equalsIgnoreCase("sim")) {
            Carro novoCarro = new Carro();

            System.out.println("\n--- Cadastrar Novo Carro ---");
            System.out.print("Modelo: ");
            novoCarro.modelo = sc.nextLine();

            System.out.print("Cor: ");
            novoCarro.cor = sc.nextLine();

            System.out.print("Tipo: ");
            novoCarro.tipo = sc.nextLine();

            System.out.print("Placa: ");
            novoCarro.placa = sc.nextLine();

            listaDeCarros.add(novoCarro);

            System.out.print("Deseja cadastrar outro carro? (sim/nao): ");
            resposta = sc.nextLine();
        }

        System.out.println("\nCarros cadastrados: " + listaDeCarros);
        Queue<List<Carro>> carrosQueue = new LinkedList<>();
        carrosQueue.add(listaDeCarros);


        System.out.println("Adicione a pessoa nome, idade");

        Pessoa p = new Pessoa();
        System.out.print("Nome: ");
        p.nome = sc.nextLine();
        System.out.print("idade: ");
        p.idade = sc.nextInt();

        Queue<Pessoa> pessoasQueue = new LinkedList<>();
        pessoasQueue.add(p);

        System.out.print("\nPessoa: " + pessoasQueue );
        System.out.print("\nQueue: " + carrosQueue);
    }
}