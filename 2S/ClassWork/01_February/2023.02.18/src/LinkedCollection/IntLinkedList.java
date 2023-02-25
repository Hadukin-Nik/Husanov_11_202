package LinkedCollection;

import java.util.*;

public class IntLinkedList<T> extends  IntLinkedCollection<T> implements List<T> {
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        indexOfBoundExceptionCheck(index);

        Elem it = getElem(index);
        Elem next = it.getNext();

        int counter = 0;
        for (Object o : c) {
            next = new Elem((Integer) o, next);
            if(counter == c.size() - 1) {
                it.setNext(next);
            }
            counter++;
        }

        return true;
    }

    //NOT IMPLEMENTED YET! DO THIS!


    @Override
    public T get(int index) {
        return get(index);
    }

    @Override
    public T set(int index, T element) {
        indexOfBoundExceptionCheck(index);
        Elem buf = getElem(index);
        T ans = (T) buf.getValue();

        buf.setValue(element);
        return ans;
    }

    @Override
    public void add(int index, T element) {
        indexOfBoundExceptionCheck(index);

        Elem buf = getElem(index);
        buf.setNext(new Elem<T>(element, buf.getNext()));
    }

    @Override
    public T remove(int index) {
        indexOfBoundExceptionCheck(index);

        Elem buf = getElem(index);
        Elem preBuf = null;
        if (index != 0) {
            preBuf = getElem(index - 1);
        }

        if(preBuf != null) {
            preBuf.setNext(buf.getNext());
        }

        buf.setNext(null);

        return (T)buf.getValue();
    }

    @Override
    public int indexOf(Object o) {
        Elem iter = head;

        for(int i = 0; i < size; i++) {
            if (iter.getValue() == (Integer) o) {
                return i;
            }

            iter = iter.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Elem iter = head;
        int ans = -1;
        for(int i = 0; i < size; i++) {
            if (iter.getValue() == (Integer) o) {
                ans = i;
            }

            iter = iter.getNext();
        }



        return ans;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        indexOfBoundExceptionCheck(fromIndex);
        indexOfBoundExceptionCheck(toIndex);

        if(fromIndex > toIndex) {
            int buf = fromIndex;
            fromIndex = toIndex;
            toIndex = buf;
        }

        if(fromIndex == toIndex) {
            return Arrays.asList(get(toIndex));
        }

        List<T> ans = new ArrayList<>();

        Elem iter = getElem(fromIndex);
        for(int i = fromIndex; i <= toIndex; i++) {
            if(iter == null) {
                ans.add(null);
                continue;
            }

            ans.add((T)iter.getValue());

            iter = iter.getNext();
        }

        return ans;
    }
    private Elem getElem(int index) {
        indexOfBoundExceptionCheck(index);

        Elem iter = head;

        for(int i = 0; i <= index; i++) {
            if (i == index) {
                return iter;
            }

            iter = iter.getNext();
        }
        return null;
    }
    private void indexOfBoundExceptionCheck(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    //HERE IS NO IMPLEMENTATION FOR NOW !!!
    @Override

    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }
}
