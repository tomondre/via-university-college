import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTest {

    private Board board;
    private int size = 4;

    @BeforeEach
    public void setUp() throws Exception {
        board = new Board(size);
    }

    @Test
    public void toStringMethodWorks() {
        //Arrange
        String result;

        //Act
        result = board.toString();

        //Assert
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void queenCreationAlgorithmWork() {
        //Arrange
        String result;

        //Act
        board.solveQueens(0);
        result = board.toString();

        //Assert
        assertNotNull(result);
    }
}
