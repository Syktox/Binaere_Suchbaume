import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

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
        Node<T> tempNode = this.root;
        Node<T> father = null;

        while (tempNode != null && value.compareTo(tempNode.getData()) != 0) {
            father = tempNode;
            if (value.compareTo(tempNode.getData()) < 0) { tempNode = tempNode.left; }
            if (value.compareTo(tempNode.getData()) > 0) { tempNode = tempNode.right; }
        }

        if (checkRootNode(tempNode)) deleteRootNode();
        if (checkLeafeNode(tempNode)) deleteLeafeNode(tempNode, father);
        if (checkMiddleNode(tempNode, father)) deleteMiddleNode(tempNode, father);
    }   

    private boolean checkRootNode(Node<T> node) {
        return (this.root != null && node.getData().compareTo(this.root.getData()) == 0);
    }

    private void deleteRootNode() {
        Node<T> tempNode = this.root;
        Node<T> father = null;

        if (tempNode == null) return;
        if (tempNode != this.root) return;
        if (tempNode.right == null) {
            this.root = root.left;
            tempNode.left = null;
            tempNode = null;
            return;
        }
        if (tempNode.right.left == null) {
            tempNode = tempNode.right;
            tempNode.left = this.root.left;
            this.root.right = null;
            this.root.left = null;
            this.root = null;
            this.root = tempNode;
            return;
        }
        tempNode = tempNode.right;
        while (tempNode.left != null) {
            father = tempNode;
            tempNode = tempNode.left;
        }
        tempNode.left = this.root.left;
        tempNode.right = this.root.right;
        father.left = null;
        this.root.left = null;
        this.root.right = null;
        this.root = null;
        this.root = tempNode;
    }

    private boolean checkLeafeNode(Node<T> node) {
        return (node.left == null && node.right == null);
    }

    private void deleteLeafeNode(Node<T> tempNode, Node<T> father) {
        if (father.right.equals(tempNode)) father.right = null;
        if (father.left.equals(tempNode)) father.left = null;
        tempNode = null;
    }

    private boolean checkMiddleNode(Node<T> node, Node<T> father) {
        if (father == null) return false;
        if (node.left == null && node.right == null) return false;
        return true;
    }

    private void deleteMiddleNode(Node<T> tempNode, Node<T> father) {
        if (tempNode.right == null) {
            if (tempNode.equals(father.left)) father.left = tempNode.left;
            if (tempNode.equals(father.right)) father.right = tempNode.left;
            tempNode.left = null;
            tempNode = null;
        } 
        else if (tempNode.left == null) {
            if (tempNode.equals(father.left)) father.left = tempNode.right;
            if (tempNode.equals(father.right)) father.right = tempNode.right;
            tempNode.right = null;
            tempNode = null;
        } 
        else {
            if (tempNode.right.left == null) {
                Node<T> fof = father;
                father = tempNode;
                tempNode = tempNode.right;
                
                if (father.equals(fof.right)) fof.right = tempNode;
                if (father.equals(fof.left)) fof.left = tempNode;
                tempNode.left = father.left;
                father.left = null;
                father.right = null;
                father = null;              
                return;
            }
            Node<T> fof = father;
            Node<T> nodeToDelete = tempNode;
            tempNode = tempNode.right;
            while (tempNode.left != null) {
                father = tempNode;
                tempNode = tempNode.left;
            }
            tempNode.left = nodeToDelete.left;
            tempNode.right = nodeToDelete.right;
            if (nodeToDelete.equals(fof.right)) fof.right = tempNode;
            if (nodeToDelete.equals(fof.left)) fof.left = tempNode;
            nodeToDelete.left = null;
            nodeToDelete.right = null;
            nodeToDelete = null;
            father.left = null;
        }
    }


    public int TreeToVine() {   
        if (this.root == null) return -1;

        Node<T> virtualNode = new Node<>();
        virtualNode.right = this.root;
        Node<T> tail = virtualNode;
        Node<T> rest = virtualNode.right;
        int count = 0;

        while (rest != null) {
            if (rest.left == null) {
                tail = rest;
                rest = tail.right;
                count++;
            } else {
                Node<T> tempNode = rest.left;
                rest.left = tempNode.right;
                tempNode.right = rest;
                rest = tempNode;
                tail.right = tempNode;
            }
        }

        this.root = virtualNode.right;
        virtualNode.right = null;
        virtualNode = null;
        return count;
    }

    public void compress(Node<T> dummyRoot, int size) {
        Node<T> tempNode = dummyRoot;
        for (int i = 0; i < size; i++) {
            Node<T> son = tempNode.right;
            tempNode.right = son.right;
            son.right = tempNode.right.left;
            tempNode.right.left = son;
            tempNode = tempNode.right;
        }
        this.root = dummyRoot;
    }

    public void VineToTree(int size) {
        if (this.root == null) return;
        int k = 1;
        int i = size;
        Node<T> dummyRoot = new Node<>();
        dummyRoot.right = this.root;

        if (!isComplete(size)) {
            while (k <= size + 1) k = 2 * k;
            i = k / 2 - 1;
            compress(dummyRoot, size - i);
        }

        while (i > 1) {
            i = i / 2;
            compress(dummyRoot, i);
        }
        
        this.root = dummyRoot.right;
        dummyRoot.right = null;
        dummyRoot = null;
    }

    public boolean isComplete(int size) {
        return ((size % 2) - 1) == 0;
    }
}