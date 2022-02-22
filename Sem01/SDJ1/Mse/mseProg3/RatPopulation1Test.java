import static org.junit.jupiter.api.Assertions.*;

class RatPopulation1Test {

    @org.junit.jupiter.api.Test
    void ratPopulationTest1() {
        RatPopulation1 ratPopulation1 = new RatPopulation1();
        assertEquals(326, ratPopulation1.ratPopulation(200,4));
    }

    @org.junit.jupiter.api.Test
    void ratPopulationTest2() {
        RatPopulation1 ratPopulation1 = new RatPopulation1();
        assertEquals(4029, ratPopulation1.ratPopulation(7,52));
    }
}