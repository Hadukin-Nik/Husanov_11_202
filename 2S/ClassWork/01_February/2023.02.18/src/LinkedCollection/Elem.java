package LinkedCollection;

class Elem {
    private int value;
    private Elem next;

    Elem(int value, Elem next) {
        this.value = value;
        this.next = next;
    }

    Elem(int value) {
        this.value = value;
    }

    public Elem getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Elem next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
