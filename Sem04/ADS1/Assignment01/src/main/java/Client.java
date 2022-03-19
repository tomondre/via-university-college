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
            System.out.println(e.getMessage());
        }

        return result;
    }
}
