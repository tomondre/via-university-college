import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class TelephoneBillCalculatorImpl implements TelephoneBillCalculator{
    private ArrayList<Call> logs;

    public TelephoneBillCalculatorImpl(){
        logs = new ArrayList<Call>();
    }

    @Override
    public BigDecimal calculate(String phoneLog) {
        Call log = new Call(phoneLog);
        logs.add(log);
        return log.getPrice();
    }
}
