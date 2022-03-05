package assignment_01;

import assignment_01.exceptions.MalformedExpressionException;
import assignment_01.linkedList.Calculator;
import assignment_01.linkedList.LinkedStack;

public class CalculatorVisitor implements Visitor, Calculator {
    private LinkedStack<Token> tokenStack;

    private void pushOperand() {

    }

    private void performOperation(Operator operator) {

    }

    @Override
    public void visit(Operator operand) {

    }

    @Override
    public void visit(Operand operand) {

    }

    @Override
    public int getResult() throws MalformedExpressionException {
        return 0;
    }
}
