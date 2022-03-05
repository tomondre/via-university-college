package assignment_01;

public abstract class Token {
    private CalculatorVisitor visitor;

    public abstract void accept(CalculatorVisitor visitor);
}
