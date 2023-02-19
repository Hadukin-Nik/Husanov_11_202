public class Elem {
    private int value;
    private Elem previous;
    private Elem forward;

    public Elem(int value, Elem previous) {
        this.value = value;
        this.previous = previous;
    }

    public Elem(int value) {
        this.value = value;
        this.previous = null;
    }

    public Elem() {
        this.value = 0;
        this.previous = null;
    }

    public Elem getPrevious() {
        return previous;
    }

    public int getValue() {
        return value;
    }

    public void setPrevious(Elem previous) {
        this.previous = previous;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Elem getForward() {
        return forward;
    }

    public void setForward(Elem forward) {
        this.forward = forward;
    }
}
