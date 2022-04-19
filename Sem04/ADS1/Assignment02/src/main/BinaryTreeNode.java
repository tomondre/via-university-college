
public class BinaryTreeNode<E> {
    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
