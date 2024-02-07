public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(10);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(7);
        binaryTree.insert(6);
        binaryTree.insert(5);
        binaryTree.insert(4);

        binaryTree.insert(15);
        binaryTree.insert(13);
        binaryTree.insert(20);
        binaryTree.insert(19);
        binaryTree.insert(18);
        binaryTree.insert(17);

        try {
            int length = binaryTree.TreeToVine();
            binaryTree.VineToTree(length);
            binaryTree.inorder();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}