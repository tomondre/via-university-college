public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    public BinarySearchTree() {
        setRoot(null);
    }

    public boolean insert(E element) {
        if (getRoot() == null) {
            setRoot(new BinarySearchTreeNode<>(element));
            return true;
        }
        return insert(getRoot(), element);
    }

    private boolean insert(BinaryTreeNode<E> node, E element) {
        int compare = node.getElement().compareTo(element);
        switch (compare) {
            case 1:
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new BinarySearchTreeNode<>(element));
                    return true;
                }
                return insert(node.getLeftChild(), element);

            default:
                return false;

            case -1:
                if (node.getRightChild() == null) {
                    node.setRightChild(new BinarySearchTreeNode<>(element));
                    return true;
                }
                return insert(node.getRightChild(), element);
        }
    }


    public boolean removeElement(E element) {
        BinaryTreeNode<E> root = getRoot();
        if (root == null) {
            return false;
        }
        return removeElement(root, element);
    }

    public boolean removeElement(BinaryTreeNode<E> node, E element) {
        int compare = node.getElement().compareTo(element);
        switch (compare) {
            case 1 -> {
                BinaryTreeNode<E> leftChild = node.getLeftChild();
                if (leftChild == null) return false;
                if (leftChild.getElement().compareTo(element) == 0) {
                    node.setLeftChild(leftChild.getRightChild());
                    return true;
                }
                return removeElement(leftChild, element);
            }
            case -1 -> {
                BinaryTreeNode<E> rightChild = node.getRightChild();
                if (rightChild == null) return false;
                if (rightChild.getElement().compareTo(element) == 0) {
                    node.setRightChild(rightChild.getRightChild());
                    return true;
                }
                return removeElement(rightChild, element);
            }
            default -> {
                setRoot(getRoot().getRightChild());
                return true;
            }
        }
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
        if (element == null) {
            return false;
        }
        return contains(getRoot(), element);
    }

    private boolean contains(BinaryTreeNode<E> node, E element) {
        if (node == null) {
            return false;
        }
        int compare = node.getElement().compareTo(element);
        switch (compare) {
            case 1:
                return contains(node.getLeftChild(), element);
            case -1:
                return contains(node.getRightChild(), element);
            default:
                return true;
        }
    }

    public void rebalance() {
        BinaryTreeNode<E> root = getRoot();
        if (root == null) {
            return;
        }

        int leftChildHeight = height(root.getLeftChild());
        int rightChildHeight = height(root.getRightChild());

        int diff = rightChildHeight - leftChildHeight;

        if (diff > 1){
            BinaryTreeNode<E> rightChild = root.getRightChild();
            root.setRightChild(null);
            rightChild.setLeftChild(root);
            setRoot(rightChild);
        } else if(diff < -1) {
            BinaryTreeNode<E> leftChild = root.getLeftChild();
            root.setLeftChild(null);
            leftChild.setRightChild(root);
            setRoot(leftChild);
        } else {
            return;
        }
        rebalance();
    }
}