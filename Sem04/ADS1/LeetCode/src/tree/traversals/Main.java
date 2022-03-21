package tree.traversals;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("A");

        Node n1 = new Node("B");
        root.left = n1;

        Node n2 = new Node("C");
        root.right = n2;

        Node n3 = new Node("D");
        n1.left = n3;

        Node n4 = new Node("E");
        n1.right = n4;

        Node n5 = new Node("F");
        n2.left = n5;

        postOrderTraversal(root);
    }

    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.value);
        inOrderTraversal(root.right);
    }


    public static void postOrderTraversal(Node root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value);
    }
}
