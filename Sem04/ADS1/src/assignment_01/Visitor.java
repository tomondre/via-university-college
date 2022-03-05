package assignment_01;

public interface Visitor {
    void visit(Operator operand);
    void visit(Operand operand);
}
