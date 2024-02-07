public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(10);
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(7);
        binaryTree.insert(6);


        try {
            int length = binaryTree.TreeToVine();
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}