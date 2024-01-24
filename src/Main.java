public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(12);
        binaryTree.insertRec(13);
        binaryTree.insertRec(11);
        System.out.println(binaryTree.root.getData());
        System.out.println(binaryTree.root.left.getData());
        System.out.println(binaryTree.root.right.getData());
    }
}