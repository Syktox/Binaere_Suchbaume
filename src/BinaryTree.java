import java.util.Stack;

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
        System.out.println("Can't programm this");
    }

    // rekursive
    public void postorderRec() {
        postorderRec(this.root);
    }

    private void postorderRec(Node<T> node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.println(node.getData());
        }
    }

    public void preorder() {
        if (this.root == null) {
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        Node<T> tempNode = this.root;

        while (!stack.isEmpty() || tempNode != null) {
            if (tempNode != null) {
                System.out.println(tempNode.getData());
                stack.push(tempNode);
                tempNode = tempNode.left;
            } else {
                Node<T> prevNode = stack.pop();
                tempNode = prevNode.right;
            }
        }
    }

    // rekursive
    public void preorderRec() {
        preorderRec(this.root);
    }

    private void preorderRec(Node<T> node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // iterative
    public void inorder() {
        if (this.root == null) {
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        Node<T> tempNode = this.root;

        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            System.out.println(tempNode.getData());
            tempNode = tempNode.right;
        }
    }

    // rekursive
    public void inorderRec() {
        inorderRec(this.root);
    }

    private void inorderRec(Node<T> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.getData());
            inorderRec(node.right);
        }
    }

    public void delete(T value) {
        if (value.compareTo(this.root.getData()) == 0) {
            if (this.root.right.left == null) {
                Node<T> newRootNode = this.root.right;
                newRootNode.left = this.root.left;
                this.root = null;
                this.root = newRootNode;
            } else {
                Node<T> newRootNode = this.root.right;
                Node<T> fatherNode = null;
                while (newRootNode.left != null) {
                    fatherNode = newRootNode;
                    newRootNode = newRootNode.left;
                }
                newRootNode.left = this.root.left;
                newRootNode.right = this.root.right;
                this.root = null;       // Speicherleiche verhinder ? ! 
                this.root = newRootNode;
                fatherNode.left = null;
            }
        }
        Node<T> tempNode = this.root;
        Node<T> fatherNode = null;
        
        while (tempNode != null && tempNode.getData() != value) {
            fatherNode = tempNode;
            if (value.compareTo(tempNode.getData()) < 0) { tempNode = tempNode.left; }
            if (value.compareTo(tempNode.getData()) > 0) { tempNode = tempNode.right; }
        }

        if (tempNode == null) { return; }
        if (tempNode.left == null && tempNode.right == null) { 
            if (fatherNode.left.equals(tempNode)) { fatherNode.left = null; }
            if (fatherNode.right.equals(tempNode)) { fatherNode.right = null; }
            tempNode = null; 
        }

    }   

    public void TreeToVine() {
        // todo
    }

    public void VineToTree() {
        // todo
    }

}
