import java.util.EmptyStackException;

public class CalculatorVisitor implements Visitor, Calculator {
    private LinkedStack<Integer> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand.getValue());
    }

    private void performOperation(Operator operator) {
        int o2 = tokenStack.pop();
        int o1 = tokenStack.pop();

        int result = 0;
        result = switch (operator.getOperation()){
            case PLUS -> o1 + o2;
            case MINUS -> o1 - o2;
            case DIVIDE -> o1 / o2;
            case MULTIPLY -> o1 * o2;
        };

        pushOperand(new Operand(result));
    }

    @Override
    public void visit(Operator operand) {
        performOperation(operand);
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public int getResult() throws MalformedExpressionException {
        try {
            return tokenStack.pop();
        } catch (EmptyStackException e) {
            throw new MalformedExpressionException();
        }
    }
}
