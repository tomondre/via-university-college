package tree.binarySearchTree;

public class Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTreeADT tree = new BinaryTreeADT();

        tree.add(new Node(10));
        tree.add(new Node(15));
        tree.add(new Node(5));
        tree.add(new Node(3));
        tree.add(new Node(13));

        System.out.println(tree.removeElement(new Node(10)));
    }
}
