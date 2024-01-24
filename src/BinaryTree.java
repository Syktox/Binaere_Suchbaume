public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    BinaryTree() {
        this.root = null;
    }

    BinaryTree(Node<T> root) {
        this.root = root;
    }

    // iterative
    public void insert(T data) {
        Node<T> tempNode = this.root;
        Node<T> father = null;

        if (tempNode == null) {
            this.root = new Node<>(data);
            return;
        }

        while (tempNode != null) {
            father = tempNode;
            if (data.compareTo(tempNode.getData()) <= 0) { tempNode = tempNode.left; }
            else if (data.compareTo(tempNode.getData()) > 0) { tempNode = tempNode.right; }
        }

        if (data.compareTo(father.getData()) <= 0) { father.left = new Node<>(data); }
        if (data.compareTo(father.getData()) > 0) { father.right = new Node<>(data); }
    }

    // insert recursive
    public void insertRec(T value) {
        root = insertRec(value, this.root);
    }

    private Node<T> insertRec(T value, Node<T> node) {
        if (node == null) {
            node = new Node<>(value);
            return node;
        }
        if (value.compareTo(node.getData()) < 0) {
            node.left = insertRec(value, node.left);
        } else {
            node.right = insertRec(value, node.right);
        }
        return node;
    }

    // binary search O(log n)
    // iterative
    public Node<T> search(T data) {
        Node<T> tempNode = this.root;
        while (tempNode != null) {
            if (data.compareTo(tempNode.getData()) == 0) { return tempNode; }
            if (data.compareTo(tempNode.getData()) < 0) { tempNode = tempNode.left; }
            if (data.compareTo(tempNode.getData()) > 0) { tempNode = tempNode.right; }
        }
        return null;
    }

    // rekursive
    public Node<T> searchRec(T data) {
        return searchRec(data, this.root);
    }

    private Node<T> searchRec(T data, Node<T> node) {
        if (node == null || node.getData() == data) { return node; }
        if (data.compareTo(node.getData()) < 0) { return searchRec(data, node.left); }
        if (data.compareTo(node.getData()) > 0) { return searchRec(data, node.right); }
        return null;
    }

    public void postorder() {
        // todo
    }

    public void preorder() {
        // todo
    }

    // iterative
    public void inorder() {
        // todo
    }

    // rekursive
    public void inorderRec() {
        inorderRec(root);
    }

    private void inorderRec(Node<T> node) {
        if (root != null) {
            inorderRec(node.left);
            System.out.println(node.getData());
            inorderRec(root.right);
        }
    }

    public void TreeToVine() {
        // todo
    }

    public void VineToTree() {
        // todo
    }

}
