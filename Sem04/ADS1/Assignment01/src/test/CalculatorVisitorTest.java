import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorVisitorTest {

    private CalculatorVisitor visitor;
    private ArrayList<Operand> operands;

    @BeforeEach
    void beforeEach() {
        visitor = new CalculatorVisitor();

        operands = new ArrayList<>();
        operands.add(new Operand(10));
        operands.add(new Operand(5));
    }

    @Test
    void visitOperatorException() {
        assertThrows(MalformedExpressionException.class, () -> visitor.getResult());
    }

    @Test
    void visitOperatorPlus() throws MalformedExpressionException {
        loadOperands(visitor, operands);
        visitor.visit(new Operator(Operation.PLUS));

        int result = visitor.getResult();

        assertEquals(15, result);
    }

    @Test
    void visitOperatorMinus() throws MalformedExpressionException {
        loadOperands(visitor, operands);
        visitor.visit(new Operator(Operation.MINUS));

        int result = visitor.getResult();

        assertEquals(5, result);
    }


    @Test
    void visitOperatorMultiply() throws MalformedExpressionException {
        loadOperands(visitor, operands);
        visitor.visit(new Operator(Operation.MULTIPLY));

        int result = visitor.getResult();

        assertEquals(50, result);
    }

    @Test
    void visitOperatorDivide() throws MalformedExpressionException {
        loadOperands(visitor, operands);
        visitor.visit(new Operator(Operation.DIVIDE));

        int result = visitor.getResult();

        assertEquals(2, result);
    }

    @Test
    void visitOperandCorrect() {
        Operand o1 = new Operand(1);

        visitor.visit(o1);

        int result = 0;
        try {
            result = visitor.getResult();
        } catch (MalformedExpressionException e) {
            e.printStackTrace();
        }
        assertEquals(1, result);
    }

    @Test
    void getResult() {
    }

    private void loadOperands(CalculatorVisitor visitor, ArrayList<Operand> operands) {
        for(Operand operand : operands) {
            visitor.visit(operand);
        }
    }
}