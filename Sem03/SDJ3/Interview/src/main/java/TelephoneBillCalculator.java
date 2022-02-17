import java.math.BigDecimal;
import java.math.BigInteger;

public interface TelephoneBillCalculator {
    BigDecimal calculate(String phoneLog);
}