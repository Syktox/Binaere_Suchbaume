public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.insert(13);
        binaryTree.insert(2);
        binaryTree.insert(5);
        binaryTree.insert(18);
        binaryTree.insert(17);
        binaryTree.insert(16);
        binaryTree.insert(15);

        try {
            System.out.println("postorder: \n");
            System.out.println("before deleting");
            binaryTree.preorder();
            System.out.println("\n\nafter deleting");
            binaryTree.delete(5); 
            binaryTree.preorder();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}