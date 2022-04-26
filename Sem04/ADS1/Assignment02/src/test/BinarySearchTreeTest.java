import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> tree;
    private BinarySearchTree<Integer> unbalancedTree;

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

        unbalancedTree = new BinarySearchTree<>();
        unbalancedTree.insert(1);
        unbalancedTree.insert(2);
        unbalancedTree.insert(3);
        unbalancedTree.insert(4);
        unbalancedTree.insert(5);
        unbalancedTree.insert(6);
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

    @Test
    void containsFalse() {
        //Arrange
        int toCompare = 25;

        //Act
        boolean contains = tree.contains(toCompare);

        //Assert
        assertFalse(contains);
    }

    @Test
    void containsTrue() {
        //Arrange
        int toCompare = 10;

        //Act
        boolean contains = tree.contains(toCompare);

        //Assert
        assertTrue(contains);
    }

    @Test
    void removeElementExisting() {
        //Arrange
        int toRemove = 10;
        boolean beforeDeletion;
        boolean afterDeletion;
        boolean isRemoved;

        //Act
        beforeDeletion = tree.contains(toRemove);
        isRemoved = tree.removeElement(toRemove);
        afterDeletion = tree.contains(toRemove);

        //Assert
        assertTrue(beforeDeletion);
        assertFalse(afterDeletion);
        assertTrue(isRemoved);
    }

    @Test
    void removeElementRoot() {
        //Arrange
        int toRemove = 5;
        boolean beforeDeletion;
        boolean afterDeletion;
        boolean isRemoved;

        //Act
        beforeDeletion = tree.contains(toRemove);
        isRemoved = tree.removeElement(toRemove);
        afterDeletion = tree.contains(toRemove);

        //Assert
        assertTrue(beforeDeletion);
        assertFalse(afterDeletion);
        assertTrue(isRemoved);
    }

    @Test
    void removeElementLeaf() {
        //Arrange
        int toRemove = 1;
        boolean beforeDeletion;
        boolean afterDeletion;

        boolean isRemoved;

        //Act
        beforeDeletion = tree.contains(toRemove);
        isRemoved = tree.removeElement(toRemove);
        afterDeletion = tree.contains(toRemove);

        //Assert
        assertTrue(beforeDeletion);
        assertFalse(afterDeletion);
        assertTrue(isRemoved);
    }

    @Test
    void removeElementNotExisting() {
        //Arrange
        int toRemove = 50;
        boolean beforeDeletion;
        boolean afterDeletion;
        boolean isRemoved;

        //Act
        beforeDeletion = tree.contains(toRemove);
        isRemoved = tree.removeElement(toRemove);
        afterDeletion = tree.contains(toRemove);

        //Assert
        assertFalse(beforeDeletion);
        assertFalse(afterDeletion);
        assertFalse(isRemoved);
    }

    @Test
    void rebalance() {
        //Arrange
        int beforeBalanceHeight;
        int afterBalanceHeight;

        //Act
        beforeBalanceHeight = unbalancedTree.height();
        unbalancedTree.rebalance();
        afterBalanceHeight = unbalancedTree.height();

        //Assert
        int valueToCheck = (beforeBalanceHeight / 2) - afterBalanceHeight;


        assertTrue(valueToCheck <= 1);
        assertTrue(valueToCheck >= -1);
    }
}