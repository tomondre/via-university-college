import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {

    private Operand operand;

    @BeforeEach
    void beforeEach() {
        operand = new Operand(1);
    }

    @Test
    void getValue() {
        int value = operand.getValue();

        assertEquals(1, value);
    }
}