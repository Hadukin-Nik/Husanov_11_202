import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayListTest {

    @Test
    void addAll() {
        IntArrayList<Integer> arr1 = new IntArrayList<>();

        arr1.addAll(0, Arrays.asList(123, 123, 123));
        Assertions.assertEquals(Arrays.asList(123, 123, 123), Arrays.asList(arr1.toArray()));
    }

    @Test
    void get() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.add(5);
        Assertions.assertEquals(5, arr.get(0));
    }

    @Test
    void set() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.add(5);
        arr.set(0, 78);
        Assertions.assertNotEquals(5, arr.get(0));
        Assertions.assertEquals(78, arr.get(0));
    }

    @Test
    void add() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.add(5);
        arr.add(0, 6);
        Assertions.assertEquals(Arrays.asList(6,5), Arrays.asList(arr.toArray()));
        Assertions.assertNotEquals(Arrays.asList(5, 6), Arrays.asList(arr.toArray()));
    }

    @Test
    void remove() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.add(5);
        arr.remove(0);
        assertEquals(0, arr.size());

        arr.addAll(Arrays.asList(1,2,4,5,3));
        arr.remove(1);
        assertEquals(Arrays.asList(1,4,5,3), Arrays.asList(arr.toArray()));
    }

    @Test
    void indexOf() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.addAll(Arrays.asList(1,2,4,5,3));

        Assertions.assertEquals(0, arr.indexOf(1));
        Assertions.assertEquals(-1, arr.indexOf(32));
    }

    @Test
    void lastIndexOf() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.addAll(Arrays.asList(2,1,1,2,4,5,3));

        Assertions.assertEquals(0, arr.lastIndexOf(2));
        Assertions.assertEquals(-1, arr.lastIndexOf(32));
    }

    @Test
    void subList() {
        IntArrayList<Integer> arr = new IntArrayList<>();

        arr.addAll(Arrays.asList(2,1,1,2,4,5,3));
        Assertions.assertEquals(Arrays.asList(2,1,1,2), Arrays.asList(arr.subList(0, 4).toArray()));
        Assertions.assertNotEquals(Arrays.asList(2,1,1,2), Arrays.asList(arr.subList(1, 5).toArray()));
    }
}