package LinkedCollection;

class Elem<T> {
    private T value;
    private Elem next;

    Elem(T value, Elem next) {
        this.value = value;
        this.next = next;
    }

    Elem(T value) {
        this.value = value;
    }

    public Elem getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Elem next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Elem) {
            return ((Elem<?>) obj).getValue().equals(value);
        }
        return false;
    }
}
