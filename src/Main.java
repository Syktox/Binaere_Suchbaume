public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(10);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(7);
        binaryTree.insert(6);
        binaryTree.insert(50);
        binaryTree.insert(70);
        binaryTree.insert(20);
        binaryTree.insert(21);
        binaryTree.insert(30);
        binaryTree.insert(600);

        try {
            int length = binaryTree.TreeToVine();
            binaryTree.VineToTree(length);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}