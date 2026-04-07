import java.util.Stack;

public class pilha {
    public static void main(String[] args) {

        Stack<String> ResidentEvil = new Stack<>();

        ResidentEvil.push("Biohazard");
        ResidentEvil.push("Reqiem");

        System.out.println("topo " + ResidentEvil.pop());

        System.out.println(ResidentEvil.empty()?"vazio":"com elemento");
        
        //Printar se esta vazia ou nao.

        for (String r:ResidentEvil) {
            System.out.println(r);
        }
    }
