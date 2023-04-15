package testBase;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>(new Node(16));

        bt.add(123);

        bt.add(5);

        bt.add(4);

        bt.add(120);

        bt.add(135);
        bt.remove(16);
        bt.printTree();
    }
}
