public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.insert(13);
        binaryTree.insert(14);
        binaryTree.insert(2);
        binaryTree.insert(5);
        binaryTree.insert(19);
        binaryTree.insert(88);


        try {
            System.out.println(binaryTree.root.getData());
            System.out.println(binaryTree.root.right.getData());
            System.out.println(binaryTree.root.left.right.getData());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}