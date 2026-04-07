import java.util.Stack;

public class pilha {
    public static void main(String[] args) {

        Stack<String> ResidentEvil = new Stack<>();

        ResidentEvil.push("Biohazard");
        ResidentEvil.push("Requiem");

        System.out.println("topo " + ResidentEvil.pop());

        ResidentEvil.clear();

        //Limpar a pilha

        System.out.println(ResidentEvil.empty()?"vazio":"com elemento");


        for (String r:ResidentEvil) {
            System.out.println(r);
        }
    }
}
