import java.util.Stack;
//pega o primeiro elemento da pilha (reqiem).
//o ltimo e o primeiro

public class pilha {
    public static void main(String[] args) {

        Stack<String> ResidentEvil = new Stack<>();

        ResidentEvil.push("Biohazard");
        ResidentEvil.push("Reqiem");

        System.out.println("topo " + ResidentEvil.peek());

        for (String r:ResidentEvil) {
            System.out.println(r);
        }
    }
}
