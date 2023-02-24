import java.util.Collection;
import java.util.Iterator;

public class IntArrayCollection implements Collection<Integer> {
    protected final double LOAD_FACTOR = 0.75;

    protected int[] array;
    protected int size;

    protected int capacity;

    public IntArrayCollection(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;

        this.size = 0;
    }

    public IntArrayCollection() {
        array = new int[0];
        this.capacity = 0;

        this.size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return(findAndReturn(o) == -1);
    }

    @Override
    public boolean add(Integer integer) {
        if (size > array.length - 1) {
            resize();
        }

        array[size] = integer;
        size++;

        return false;
    }

    @Override
    public boolean remove(Object o) {
        int i = findAndReturn(o);

        if (i != -1) {
            array[i] = 0;

            for(int j = i + 1; j < size; j++) {
                array[j - 1] = array[j];

                array[j] = 0;
            }

            return true;
        }

        return false;
    }

    private int findAndReturn(Object o) {
        int f = 0;

        if (o instanceof  Integer) {
            f = (Integer)o;
        }

        for (int i = 0; i < size; i++) {
            if(array[i] == f) {
                return i;
            }
        }

        return -1;
    }

    protected void resize() {
        capacity = (int)(capacity / LOAD_FACTOR);
        int[] arrNew = new int[capacity];

        for (int i = 0; i < array.length; i++) {
            arrNew[i] = array[i];
        }

        array = arrNew;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object f : c) {
            if(!contains(f)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for(Object f : c) {
            add((Integer) f);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (int i = 0; i < size(); i++) {
            if(!c.contains(array[i])) {
                this.remove(array[i]);
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size(); i++) {
            if(c.contains(array[i])) {
                this.remove(array[i]);
            }
        }

        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }


    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = array[i];
        }

        return new int[][]{ans};
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

}
