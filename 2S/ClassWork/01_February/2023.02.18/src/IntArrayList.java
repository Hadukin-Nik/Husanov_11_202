import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class IntArrayList extends IntArrayCollection implements List<Integer>{

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        indexOfBoundExceptionCheck(index);

        if(c.size() + size > capacity * LOAD_FACTOR) {
            resize();
        }

        int[] tail = new int[size - index];

        for(int i = index; i <= size; i++) {
            tail[i] = array[i];
        }

        for (int i = index; i - index < c.size(); i++) {

        }
        int j = index;
        for (Object o : c) {
            array[j] = (Integer)o;

            j++;
        }

        for (int i = index + c.size(); i - index - c.size() < tail.length; i++) {
            array[i] = tail[i - index - c.size()];
        }

        return true;
    }

    @Override
    public Integer get(int index) {
        indexOfBoundExceptionCheck(index);

        return array[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        indexOfBoundExceptionCheck(index);

        int ans = array[index];

        array[index] = element;

        return ans;
    }

    @Override
    public void add(int index, Integer element) {
        indexOfBoundExceptionCheck(index);


        if (index + 1 > capacity) {
            this.resize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size ++;
    }

    @Override
    public Integer remove(int index) {
        indexOfBoundExceptionCheck(index);

        int ans = array[index];

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
        for (int i = size - 1; i >= 0; i--) {
            if((Integer) o == array[i]) {
                return i;
            }
        }

        return -1;
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
        List<Integer> ans = new IntArrayList();
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
