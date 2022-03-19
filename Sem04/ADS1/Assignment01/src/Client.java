import java.util.ArrayList;

public class Client {

    private CalculatorVisitor tokenStack;

    public Client() {
        tokenStack = new CalculatorVisitor();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) {
        for (Token token: tokenList) {
            token.accept(tokenStack);
        }

        int result = -1;
        try {
            result = tokenStack.getResult();

        } catch (Exception e) {
        }

        return result;
    }

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
