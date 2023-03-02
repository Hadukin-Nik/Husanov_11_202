import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection<T> implements Collection<T>, Iterable<T> {
    protected final double LOAD_FACTOR = 0.75;

    protected T[] array;
    protected int size;

    protected int capacity;

    public ArrayCollection(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;

        this.size = 0;
    }

    public ArrayCollection() {
        array = (T[]) new Object[0];
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
        return(findAndReturn(o) != -1);
    }

    @Override
    public boolean add(T object) {
        if (size > array.length - 1) {
            resize();
        }

        array[size] = object;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = findAndReturn(o);

        if(size < 1) {
            return false;
        }

        if (i != -1) {
            array[i] = null;

            for(int j = i + 1; j < size; j++) {
                array[j - 1] = array[j];

                array[j] = null;
            }

            size--;
            return true;
        }

        return false;
    }

    private int findAndReturn(Object o) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    protected void resize() {
        capacity = (int)(capacity / LOAD_FACTOR);
        if(capacity == (int)(capacity / LOAD_FACTOR)) {
            capacity ++;
        }
        T[] arrNew = (T[])new Object[capacity];

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
    public boolean addAll(Collection<? extends T> c) {
        for(Object f : c) {
            add((T) f);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (int i = size() - 1; i >= 0; i--) {
            if(c.contains(array[i])) {
                this.remove(array[i]);
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = size() - 1; i >= 0; i--) {
            if(!c.contains(array[i])) {
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
    public Iterator<T> iterator() {
        return new ArrayCollectionIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] ans = new Object[size];

        for (int i = 0; i < size; i++) {
            ans[i] = array[i];
        }

        return ans;
    }
    //Implementation?
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
    class ArrayCollectionIterator implements Iterator<T> {
        private int index;

        ArrayCollectionIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T element = array[index];
            index ++;
            return element;
        }
    }
}
