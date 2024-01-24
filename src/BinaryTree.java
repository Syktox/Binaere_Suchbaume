public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    BinaryTree() {
        this.root = null;
    }

    BinaryTree(Node<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
            return;
        }


        if (data.compareTo(root.getData()) > 0) {
            root.right = new Node<>(data);
        } else {
            root.left = new Node<>(data);
        }
    }

    public void insertRec(T value) {
        Node<T> tempNode = root;
        insertRec(value, tempNode);
    }

    private void insertRec(T value, Node<T> tNode) {
        if (tNode == null) {
            tNode = new Node<>(value);
            return;
        }
        if (value.compareTo(tNode.getData()) > 0) {
            tNode = tNode.left;
            insertRec(value, tNode);
        } else {
            tNode = tNode.right;
            insertRec(value, tNode);
        }
    }

    public T search(T data) {
        Node<T> tempNode = root;
        if (data.compareTo(root.getData()) > 0) {
            tempNode = tempNode.left;
        } else if (data.compareTo(root.getData()) < 0) {
            tempNode = tempNode.right;
        } else if (data.compareTo(root.getData()) == 0) {
            return  tempNode.getData();
        }
        return null;
    }

    public void postorder() {
        // todo
    }

    public void preorder() {
        // todo
    }

    public void inorder() {
        // todo
    }

    public void TreeToVine() {
        // todo
    }

    public void VineToTree() {
        // todo
    }

}
