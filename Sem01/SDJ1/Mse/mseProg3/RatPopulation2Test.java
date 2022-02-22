import static org.junit.jupiter.api.Assertions.*;

class RatPopulation2Test {

    @org.junit.jupiter.api.Test
    void ratPopulation1() {
        RatPopulation2 ratPopulation2 = new RatPopulation2();
        assertEquals(576, ratPopulation2.ratPopulation2(52, 1.13));
    }
    @org.junit.jupiter.api.Test
    void ratPopulation2() {
        RatPopulation2 ratPopulation2 = new RatPopulation2();
        assertEquals(4, ratPopulation2.ratPopulation2(12, 1.13));
    }
}