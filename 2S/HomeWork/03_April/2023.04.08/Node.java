public class Node <T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(T value) {
        this.value = value;

        left = null;
        right = null;
    }


    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> value) {
        this.right = value;
    }
}
