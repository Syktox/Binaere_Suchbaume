public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(10);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(7);
        binaryTree.insert(6);

        binaryTree.insert(50);
        binaryTree.insert(20);
        binaryTree.insert(80);
        binaryTree.insert(100);
        binaryTree.insert(90);
        binaryTree.insert(70);
        binaryTree.insert(60);
        binaryTree.insert(75);

        try {
            int length = binaryTree.TreeToVine();
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}