import java.util.ArrayList;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<E> currentNode) {
        if (currentNode == null)
        {
            return 0;
        }
        return size(currentNode.getLeftChild()) + 1 + size(currentNode.getRightChild());
    }

    public boolean isEmpty() {
        return root == null;
    }

    public ArrayList<E> postOrder() {
        ArrayList<E> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(BinaryTreeNode<E> node, ArrayList<E> result) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild(), result);
        postOrder(node.getRightChild(), result);
        result.add(node.getElement());
    }

    public ArrayList<E> inOrder() {
        ArrayList<E> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(BinaryTreeNode<E> node, ArrayList<E> result) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild(), result);
        result.add(node.getElement());
        inOrder(node.getRightChild(), result);
    }

    public ArrayList<E> preOrder() {
        ArrayList<E> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(BinaryTreeNode<E> node, ArrayList<E> result) {
        if (node == null) {
            return;
        }
        result.add(node.getElement());
        preOrder(node.getLeftChild(), result);
        preOrder(node.getRightChild(), result);
    }

    public ArrayList<E> levelOrder() {
        int height = 4;

        ArrayList<E> result = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            levelOrder(root, i, result);
        }
        return result;
    }

    private void levelOrder(BinaryTreeNode<E> node, int depth, ArrayList<E> result) {
        if (node == null) {
            return;
        }

        if (depth == 0) {
            result.add(node.getElement());
            return;
        }

        levelOrder(node.getLeftChild(), depth - 1, result);
        levelOrder(node.getRightChild(), depth - 1, result);
    }

    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode<E> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeftChild());
        int rightHeight = height(node.getRightChild());
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
