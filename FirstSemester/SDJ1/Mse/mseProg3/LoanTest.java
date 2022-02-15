import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @org.junit.jupiter.api.Test
    void loan1() {
        Loan loan = new Loan();
        assertEquals(2161, loan.loan(15000, 0.05, 30));
    }

    @org.junit.jupiter.api.Test
    void loan2() {
        Loan loan = new Loan();
        assertEquals(4437, loan.loan(10000, 0.1, 3));
    }

}