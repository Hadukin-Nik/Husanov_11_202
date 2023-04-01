public class Elem {
    private int index;
    private int number;

    private Elem next;

    Elem() {
        this.index = 0;
        this.number = 0;
    }

    Elem(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    public Elem getNext() {
        return next;
    }

    public void setNext(Elem next) {
        this.next = next;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
