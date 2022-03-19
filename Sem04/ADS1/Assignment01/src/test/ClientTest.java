import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;
    private ArrayList<Token> tokens;

    @BeforeEach
    void beforeEach() {
        tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(2));
        tokens.add(new Operator(Operation.PLUS));
        tokens.add(new Operand(2));
        tokens.add(new Operator(Operation.MULTIPLY));
        tokens.add(new Operand(4));
        tokens.add(new Operator(Operation.DIVIDE));
        tokens.add(new Operand(2));
        tokens.add(new Operator(Operation.MINUS));

        client = new Client();
    }

    @Test
    void evaluateExpressionCorrect() {
        int i = client.evaluateExpression(tokens);

        assertEquals(0, i);
    }

    @Test
    void evaluateExpressionNothingInStack() {
        var tokens = new ArrayList<Token>();

        int i = client.evaluateExpression(tokens);

        assertEquals(-1, i);
    }
}