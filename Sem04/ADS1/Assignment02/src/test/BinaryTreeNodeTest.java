import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> node;
    private BinaryTreeNode<Integer> leftChild;
    private BinaryTreeNode<Integer> rightChild;

    @BeforeEach
    public void setUp() {
        node = new BinaryTreeNode<>(5);
        leftChild = new BinaryTreeNode<>(1);
        rightChild = new BinaryTreeNode<>(2);

    }

    @Test
    public void nodeIsNotNullWhenCreated() {
        //Arrange
        BinaryTreeNode<Integer> node;

        //Act
        node = new BinaryTreeNode<Integer>(1);

        //Assert
        assertNotEquals(null, node);
    }

    @Test
    public void getElement() {
        //Arrange
        Integer element;

        //Act
        element = node.getElement();

        //Assert
        assertEquals(5, element);
    }

    @Test
    public void setElement() {
        //Arrange
        Integer element;

        //Act
        node.setElement(10);
        element = node.getElement();

        //Assert
        assertEquals(10, element);
    }

    @Test
    public void getLeftChildNullWhenCreated() {
        //Arrange
        BinaryTreeNode<Integer> element;

        //Act
        element = node.getLeftChild();

        //Assert
        assertNull(element);
    }

    @Test
    public void getRightChildNullWhenCreated() {
        //Arrange
        BinaryTreeNode<Integer> element;

        //Act
        element = node.getRightChild();

        //Assert
        assertNull(element);
    }

    @Test
    public void setLeftChild() {
        //Arrange
        BinaryTreeNode<Integer> element;

        //Act
        node.setLeftChild(leftChild);
        element = node.getLeftChild();

        //Assert
        assertEquals(element.getElement(), 1);
    }

    @Test
    public void setRightChild() {
        //Arrange
        BinaryTreeNode<Integer> element;

        //Act
        node.setRightChild(rightChild);
        element = node.getRightChild();

        //Assert
        assertEquals(element.getElement(), 2);
    }


}