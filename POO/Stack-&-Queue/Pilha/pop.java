import java.util.Stack;

//retira os elementoos da pilha
//requiem não aparece mais pois e o primeiro 

public class pilha {
    public static void main(String[] args) {

        Stack<String> ResidentEvil = new Stack<>();

        ResidentEvil.push("Biohazard");
        ResidentEvil.push("Reqiem");

        System.out.println("topo " + ResidentEvil.pop());

        for (String r:ResidentEvil) {
            System.out.println(r);
        }
    }
}
