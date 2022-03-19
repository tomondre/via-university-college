public class Operand extends Token{
    private int value;

    public Operand(int value) {
        this.value = value;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(new Operand(value));
    }

    public int getValue() {
        return value;
    }
}
