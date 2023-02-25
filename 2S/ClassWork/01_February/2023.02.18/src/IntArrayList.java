import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class IntArrayList<T> extends IntArrayCollection<T> implements List<T>{
    public IntArrayList() {
        super();
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        indexOfBoundExceptionCheck(index);
        T[] tail = (T[])new Object[size - index];

        while (c.size() + Math.max(size, index) > capacity * LOAD_FACTOR) {
            resize();
        }

        for(int i = index; i < size; i++) {
            tail[i] = array[i];
        }

        int j = index;
        for (Object o : c) {
            array[j] = (T)o;

            j++;
        }

        for (int i = index + c.size(); i - index - c.size() < tail.length; i++) {
            array[i] = tail[i - index - c.size()];
        }
        size += c.size();

        return true;
    }

    @Override
    public T get(int index) {
        indexOfBoundExceptionCheck(index);

        return array[index];
    }

    @Override
    public T set(int index, T element) {
        indexOfBoundExceptionCheck(index);

        T ans = array[index];

        array[index] = element;

        return ans;
    }

    @Override
    public void add(int index, T element) {
        indexOfBoundExceptionCheck(index);

        if (size + 1 > capacity) {
            this.resize();
        }
        size++;

        for (int i = size - 2; i >= index && i >= 0; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
    }

    @Override
    public T remove(int index) {
        indexOfBoundExceptionCheck(index);

        T ans = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;

        return ans;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if((Integer) o == array[i]) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int l = -1;
        for (int i = size - 1; i >= 0; i--) {
            if((Integer) o == array[i]) {
                l = i;
            }
        }

        return l;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> ans = new IntArrayList<T>();
        indexOfBoundExceptionCheck(fromIndex);
        indexOfBoundExceptionCheck(toIndex - 1);

        for (int i = fromIndex; i < toIndex; i++) {
            ans.add(array[i]);
        }

        return ans;
    }


    private void indexOfBoundExceptionCheck(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
