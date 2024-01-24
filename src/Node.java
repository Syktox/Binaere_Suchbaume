public class Node<T> {
    private final T data;
    Node<T> left;
    Node<T> right;

    Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    Node (T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node (T data, Node<T> left) {
        this.data = data;
        this.left = left;
        this.right = null;
    }

    Node (T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }
}
