import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        setRoot(null);
    }

    public boolean insert(E element) {
        if (getRoot() == null) {
            setRoot(new BinarySearchTreeNode<>(element));
            return true;
        }

        BinaryTreeNode<E> current = getRoot();

        while (true) {
            int compare = current.getElement().compareTo(element);
            switch (compare) {
                case 1:
                    if (current.getLeftChild() == null) {
                        current.setLeftChild(new BinarySearchTreeNode<>(element));
                        return true;
                    }
                    current = current.getLeftChild();
                    break;

                case 0:
                    return false;

                case -1:
                    if (current.getRightChild() == null) {
                        current.setRightChild(new BinarySearchTreeNode<>(element));
                        return true;
                    }
                    current = current.getRightChild();
                    break;
            }
        }
    }


    public boolean removeElement(E element) {
        return true;
    }

    public E findMin() {
        var current = getRoot();
        while(current.getLeftChild() != null)
        {
            current = current.getLeftChild();
        }
        return current.getElement();
    }

    public E findMax() {
        var current = getRoot();
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current.getElement();
    }

    public boolean contains(E element) {
        return true;
    }

    public void rebalance() {

    }

    public void stringify() {
//        for (int i = 0; i < height(); i++) {
//        }
//        LinkedList<E> level = new LinkedList<E>();
//        level.addAll(levelOrder());
//
//        for (int i = 1; i < 5; i++) {
//            String row = "";
//            for (int j = 0; j < i; j++) {
//                row += createSpaces(40 / (i + 1)) + level.removeFirst();
//            }
//            System.out.println(row);
//        }
    }

//    public String createSpaces(int num) {
//        String result = "";
//        for (int i = 0; i < num; i++) {
//            result += " ";
//        }
//        return result;
//    }
}