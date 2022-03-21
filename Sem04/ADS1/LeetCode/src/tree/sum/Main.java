package tree.sum;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(2);

        Node n1 = new Node(4);
        root.right = n1;

        Node n2 = new Node(3);
        root.left = n2;

        Node n3 = new Node(6);
        n2.right = n3;

        Node n4 = new Node(5);
        n2.left = n4;

        System.out.println(findSum(root));
    }

    public static int findSum(Node root) {
        if (root == null) {
            return 0;
        }
        return findSum(root.left) + findSum(root.right) + root.value;
    }
}
