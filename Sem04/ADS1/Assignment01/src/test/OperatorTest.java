import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    private Operator operator;

    @BeforeEach
    void beforeEach() {
        operator = new Operator(Operation.PLUS);
    }

    @Test
    void getOperation() {
        Operation operation = operator.getOperation();

        assertEquals(Operation.PLUS, operation);
    }
}