import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree<String> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree<>();

        var n1 = new BinaryTreeNode<>("A");

        var n2 = new BinaryTreeNode<>("B");
        var n3 = new BinaryTreeNode<>("C");
        n1.setLeftChild(n2);
        n1.setRightChild(n3);

        var n4 = new BinaryTreeNode<>("D");
        var n5 = new BinaryTreeNode<>("E");
        n2.setLeftChild(n4);
        n2.setRightChild(n5);

        tree.setRoot(n1);
    }

    @Test
    void inOrder() {
        //Arrange
        ArrayList<String> result;
        ArrayList<String> correct = new ArrayList<>(Arrays.asList("D", "B", "E", "A", "C"));

        //Assert
        result = tree.inOrder();

        //Act
        assertEquals(correct, result);
    }

    @Test
    void postOrder() {
        //Arrange
        ArrayList<String> result;
        ArrayList<String> correct = new ArrayList<>(Arrays.asList("D", "E", "B", "C", "A"));

        //Assert
        result = tree.postOrder();

        //Act
        assertEquals(correct, result);
    }

    @Test
    void preOrder() {
        //Arrange
        ArrayList<String> result;
        ArrayList<String> correct = new ArrayList<>(Arrays.asList("A", "B", "D", "E", "C"));

        //Assert
        result = tree.preOrder();

        //Act
        assertEquals(correct, result);
    }

    @Test
    void levelOrder() {
        //Arrange
        ArrayList<String> result;
        ArrayList<String> correct = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        //Assert
        result = tree.levelOrder();

        //Act
        assertEquals(correct, result);
    }

    @Test
    void getRootNullWhenCreated() {
        //Arrange
        var emptyTree = new BinaryTree<String>();
        BinaryTreeNode<String> root;

        //Act
        root = emptyTree.getRoot();

        //Assert
        assertNull(root);
    }

    @Test
    void getRootNotNullAfterPopulated() {
        //Arrange
        BinaryTreeNode<String> root;

        //Act
        root = tree.getRoot();

        //Assert
        assertNotNull(root);
    }

    @Test
    void setRootNull() {
        //Arrange
        BinaryTreeNode<String> resultRoot;

        //Act
        tree.setRoot(null);
        resultRoot = tree.getRoot();

        //Assert
        assertNull(resultRoot);
    }

    @Test
    void size() {
        //Arrange
        int size;

        //Act
        size = tree.size();

        //Assert
        assertEquals(5, size);
    }

    @Test
    void isEmptyTrue() {
        //Arrange
        boolean isEmpty;
        var emptyTree = new BinaryTree<>();

        //Act
        isEmpty = emptyTree.isEmpty();

        //Assert
        assertTrue(isEmpty);
    }

    @Test
    void isEmptyFalse() {
        //Arrange
        boolean isEmpty;

        //Act
        isEmpty = tree.isEmpty();

        //Assert
        assertFalse(isEmpty);
    }

    @Test
    void height() {
        //Arrange
        int height;

        //Act
        height = tree.height();

        //Assert
        assertEquals(3, height);
    }
}