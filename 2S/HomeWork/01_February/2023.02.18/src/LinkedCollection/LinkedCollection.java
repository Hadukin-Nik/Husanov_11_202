package LinkedCollection;

import java.util.Collection;
import java.util.Iterator;

public class LinkedCollection<T> implements Collection<T> {
    protected Elem head;
    protected int size;

    public LinkedCollection(Elem head) {
        this.head = head;

        this.size = 1;
    }

    public LinkedCollection() {
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
    public boolean add(T integer) {
        head = new Elem(integer,head);

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = findAndReturn(o);

        Elem next = null;
        Elem s = null;

        if (i != -1) {
            size --;

            Elem iter = head;
            for (int j = 0; j <= i; j++) {
                if (j == i - 1) {
                    next = iter;
                }

                if (j == i) {
                    s = iter;
                }

                iter = iter.getNext();
            }

            if(next == null) {
                head = next.getNext();

                return true;
            }

            next.setNext(s.getNext());

            return true;
        }

        return false;
    }

    private int findAndReturn(Object o) {
        int f = 0;

        if (o instanceof  Integer) {
            f = (Integer)o;
        }
        Elem iter = head;
        for (int i = 0; i < size; i++) {
            if(iter.getValue().equals(f)) {
                return i;
            }

            iter = iter.getNext();
        }

        return -1;
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
        Elem iter = head;

        for (int i = 0; i < size(); i++) {
            if(!c.contains(iter.getValue())) {
                this.remove(iter.getValue());
            }

            iter = iter.getNext();
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Elem iter = head;

        for (int i = 0; i < size(); i++) {
            if(c.contains(iter.getValue())) {
                this.remove(iter.getValue());
            }

            iter = iter.getNext();
        }

        return true;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] ans = new Object[size];
        Elem iter = head;

        for (int i = 0; i < size; i++) {
            ans[i] = iter.getValue();
            iter = iter.getNext();
        }

        return ans;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
}
