package tree.binarySearchTree;

public interface BinarySearchTreeADT {
    void add(Node element);
    int removeElement(Node element) throws Exception;
    void removeAllOccurrences();
    int removeMin();
    int removeMax();
    int findMin();
    int findMax();
}
