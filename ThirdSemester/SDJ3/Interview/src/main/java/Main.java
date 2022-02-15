import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        TelephoneBillCalculator calculator = new TelephoneBillCalculatorImpl();

        String call = "420776562353,18-01-2020 07:59:20,18-01-2020 08:01:00";
        BigDecimal calculate = calculator.calculate(call);
        System.out.println(calculate);
    }
}
