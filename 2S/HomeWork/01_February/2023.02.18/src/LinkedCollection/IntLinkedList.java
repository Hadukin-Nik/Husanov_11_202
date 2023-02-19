package LinkedCollection;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class IntLinkedList extends  IntLinkedCollection implements List<Integer> {
    //NOT IMPLEMENTED YET! DO THIS!
    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        indexOfBoundExceptionCheck(index);

        Elem it = getElem(index);
        Elem next = it.getNext();

        Elem iter;
        int counter = 0;
        for (Object o : c) {
            if(counter == 0) {
                //...
            }

            counter++;
        }
    }

    @Override
    public Integer get(int index) {

        return ;
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
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
}
