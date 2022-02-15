import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Call {

    private long number;
    private LocalDateTime start;
    private LocalDateTime end;

    public Call(long number, LocalDateTime start, LocalDateTime end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }

    public Call(String log){
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy HH:mm:ss").toFormatter();
        String[] split = log.split(",");
        try {
            number = Long.parseLong(split[0]);
            start = LocalDateTime.parse(split[1], formatter);
            end = LocalDateTime.parse(split[2], formatter);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public BigDecimal getPrice() {
        var sum = new BigDecimal("0");
        sum = sum.add(getFirstFiveMinutesPrice());
        if (!start.plusMinutes(5).isBefore(end)){
            return sum;
        }
        sum = sum.add(getRestTimePrice());
        return sum;
    }

    private BigDecimal getRestTimePrice() {
        Duration duration = Duration.between(start.minusSeconds(start.getSecond()).plusMinutes(5), end.minusSeconds(end.getSecond()).plusMinutes(1));
        long minutes = duration.toMinutes();
        double restPrice = minutes * 0.2;
        var sum = BigDecimal.valueOf(restPrice);
        return sum;
    }

    private BigDecimal getFirstFiveMinutesPrice(){
        double sum = 0;
        LocalTime startTime = start.toLocalTime();
        LocalTime endTime = end.toLocalTime();

        for (int i = 0; i < 5; i++) {
            var timeToCompare = startTime.plusMinutes(i);
            if (timeToCompare.isAfter(endTime))
                break;

            if ((timeToCompare.isBefore(LocalTime.of(8, 0)) ||
                timeToCompare.isAfter(LocalTime.of(15, 59)))){
                sum += 0.5;
            }
            else {
                sum += 1;
            }
        }
        return BigDecimal.valueOf(sum);
    }
}
