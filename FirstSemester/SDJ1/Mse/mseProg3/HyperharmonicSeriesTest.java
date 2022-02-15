import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HyperharmonicSeriesTest {

    @Test
    void hyperharmonicSeries() {
        HyperharmonicSeries hyperharmonicSeries=new HyperharmonicSeries();
        assertEquals(1.6348839001848923, hyperharmonicSeries.hyperharmonicSeries(100, 2));
        assertEquals(1.1965319856741932, hyperharmonicSeries.hyperharmonicSeries(10, 3));

    }
}