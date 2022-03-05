package assignment_01;

public class Operator extends Token {
    private Operation operation;

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(new Operator());
    }

    public Operation getOperation() {
        return operation;
    }
}
