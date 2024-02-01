public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(20);
        binaryTree.insert(13);
        binaryTree.insert(2);
        binaryTree.insert(5);
        binaryTree.insert(18);
        binaryTree.insert(34);
        binaryTree.insert(28);
        binaryTree.insert(17);
        binaryTree.insert(16);
        binaryTree.insert(15);
        binaryTree.insert(58);
        binaryTree.insert(48);

        try {
            binaryTree.delete(13); 
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}