package assignment_01;

import java.util.ArrayList;

public class Client {

    private CalculatorVisitor tokenStack;

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

}
