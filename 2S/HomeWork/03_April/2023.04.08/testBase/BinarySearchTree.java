package testBase;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <T extends Comparable<T>> {
    private Node<T> root;
    public BinarySearchTree () {
        root = null;
    }

    public BinarySearchTree (Node<T> root) {
        this.root = root;
    }

    public void add(T x) {
        Node next = root;


        if(next == null) {
            next = new Node(x);

            return;
        }

        while(next != null) {
            if(x.compareTo((T) next.getValue()) > 0) {
                if (next.getRight() == null) {
                    next.setRight(new Node<T>(x));
                    break;
                } else next = next.getRight();
            } else {
                if (next.getLeft() == null) {
                    next.setLeft(new Node<T>(x));
                    break;
                } else next = next.getLeft();
            }
        }

    }

    public boolean contains(T x) {
        if(root == null) return false;

        Node<T> iter = root;

        while(iter != null || !iter.getValue().equals(x)) {
            if (iter.getValue().compareTo(x) < 0) {
                iter = iter.getLeft();
            } else {
                iter = iter.getRight();
            }
        }

        return iter == null ? iter.equals(x) : false;
    }

    public boolean remove(T x) {
        if(root == null) return false;

        Node iter = root;

        if(iter.getValue().equals(x)) {
            moveRightUp(root, root.getRight());

            return true;
        }

        while(iter != null && !iter.getValue().equals(x)) {
            if(x.compareTo((T) iter.getValue()) >= 0) {
                if(iter.getRight() != null && iter.getRight().getValue().equals(x)) {
                    moveRightUp(iter, iter.getRight());

                    return true;
                } else {
                    iter = iter.getRight();
                }
            } else {
                if(iter.getLeft() != null && iter.getLeft().getValue().equals(x)) {
                    moveRightUp(iter, iter.getLeft());

                    return true;
                } else {
                    iter = iter.getLeft();
                }
            }
        }

        return false;
    }

    private void moveRightUp(Node<T> from, Node<T> to) {
        from.setValue(to.getValue());

        if(to.getRight() != null) {
            moveRightUp(to, to.getRight());
        } else if (to.getLeft() != null) {
            moveRightUp(to, to.getLeft());
        } else {
            from.setRight(null);
        }
    }

    public void printTree() {
        Queue<Node<T>> queueVert = new LinkedList<>();
        Queue<Integer> queueDist = new LinkedList<>();
        queueVert.add(root);
        queueDist.add(1);

        int current = 1;
        String dis = " ";
        while(!queueVert.isEmpty()) {
            if(current != queueDist.peek()) {
                System.out.println();
                dis += " ";
                current ++;
            } else {
                System.out.print(dis);
            }

            System.out.print(queueVert.peek().getValue());

            if(queueVert.peek().getLeft() != null) {
                queueVert.add(queueVert.peek().getLeft());
                queueDist.add(queueDist.peek() + 1);
            }

            if(queueVert.peek().getRight() != null) {
                queueVert.add(queueVert.peek().getRight());
                queueDist.add(queueDist.peek() + 1);
            }

            queueDist.poll();
            queueVert.poll();
        }
    }
}
