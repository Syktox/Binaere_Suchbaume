public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(15);
        binaryTree.insert(17);

        try {
            binaryTree.delete(10);
            binaryTree.inorder();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}