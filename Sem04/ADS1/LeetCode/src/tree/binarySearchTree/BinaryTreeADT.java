package tree.binarySearchTree;

public class BinaryTreeADT implements BinarySearchTreeADT {

    private Node root;

    public BinaryTreeADT() {

    }

    @Override
    public void add(Node element) {
        if (root == null) {
            root = element;
            return;
        }
        Node current = root;
        while (true) {
            if (current.value > element.value) {
                if (current.left == null) {
                    current.left = element;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = element;
                    return;
                }
                current = current.right;
            }
        }
    }

    @Override
    public int removeElement(Node element) throws Exception {
//        if (root.value == element.value) {
//
//        }
//
//        Node current = root;
//        while (true) {
//            if (current.value > element.value) {
//                if (current.left.value == element.value) {
//                    int num = current.left.value;
//                    current.left = postOrderTraversal(current.left);
//                    return num;
//                }
//                current = current.left;
//            } else if (current.value < element.value) {
//                if (current.right.value == element.value) {
//                    int num = current.right.value;
//                    current.right = current.right.left;
//                    return num;
//                }
//                current = current.right;
//            }
//        }
        return -1;
    }

    @Override
    public void removeAllOccurrences() {

    }

    @Override
    public int removeMin() {
        return ;
    }

    @Override
    public int removeMax() {
        Node current = root;
        while (current.right != null)
        {
            current = current.right;
        }
        int result = current.value;
        current = null;
        return result;
    }

    @Override
    public int findMin() {

    }

    private Node nodeMin(Node node) {
        Node current = node;
        while (current.left != null)
        {
            current = current.left;
        }
        return current;
    }

    private Node nodeMax(Node node) {
        Node current = node;
        while (current.right != null)
        {
            current = current.right;
        }
        return current;
    }

    @Override
    public int findMax() {
        return 0;
    }

    private static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.value);
        inOrderTraversal(root.right);
    }


    private static void postOrderTraversal(Node root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value);
    }
}
