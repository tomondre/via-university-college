import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(10);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        tree.insert(11);
        tree.insert(1);
    }

    @Test
    public void findMax() {
        //Arrange
        Integer max;

        //Act
        max = tree.findMax();

        //Assert
        assertEquals(11, max);
    }

    @Test
    void findMin() {
        //Arrange
        Integer min;

        //Act
        min = tree.findMin();

        //Assert
        assertEquals(1, min);
    }
}