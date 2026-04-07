import java.util.LinkedList;
import java.util.Queue;

public class fila {
    public static void main(String[] args) {

        Queue<String> carros = new LinkedList<>();


        carros.add("BMW"); //adiciona na cauda
        carros.add("ford"); //adiciona na cauda
        carros.add("tesla"); //adiciona na cauda

        System.out.println("topo " + carros.peek()); // mostrar o elemento

       System.out.println("topo " + carros.poll()); // mostrar e retirar o elemento do topo (caabeca)

        System.out.println(carros);
        System.out.println(carros.isEmpty()?"vazia":"com elementos");
    }
}
