import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(2));
        tokens.add(new Operator(Operation.PLUS));
        tokens.add(new Operand(2));
        tokens.add(new Operator(Operation.MULTIPLY));
        tokens.add(new Operand(4));
        tokens.add(new Operator(Operation.DIVIDE));
        tokens.add(new Operand(2));
        tokens.add(new Operator(Operation.MINUS));

        int i = client.evaluateExpression(tokens);
        System.out.println(i);
    }
}
