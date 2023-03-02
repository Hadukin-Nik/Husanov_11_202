import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCollectionTest {
    @Test
    public void containsAndAddCheck() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();

        arr.add(5);

        assertTrue(arr.contains(5));
    }
    @Test
    public void sizeTest() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        arr.add(5);

        Assertions.assertEquals(1, arr.size());
    }

    @Test
    public void removeTest() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        arr.add(5);

        arr.remove(5);
        assertFalse(arr.contains(5));
    }

    @Test
    public void addOverCapacity() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        arr.add(5);

        for (int i = 0; i < 100; i++) {
            arr.add(i);
            System.out.println(arr.size());
        }
        assertTrue(arr.size() >= 100 + 1);
    }

    @Test
    public void containsAllCheck() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        List<Integer> checkerFalse = Arrays.asList(123, 123, 123, 123, 123);
        List<Integer> checkerTrue = Arrays.asList(5, 101);

        arr.add(5);
        arr.add(101);
        arr.add(122);
        arr.add(145);

        assertFalse(arr.containsAll(checkerFalse));
        assertTrue(arr.containsAll(checkerTrue));
    }

    @Test
    public void addAllCheck() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        List<Integer> checkerFalse = Arrays.asList(123, 123, 123, 123, 123);
        List<Integer> checkerTrue = Arrays.asList(5, 101);

        arr.addAll(checkerFalse);

        assertFalse(arr.containsAll(checkerTrue));
        assertTrue(arr.containsAll(checkerFalse));
    }

    @Test
    public void removeAllCheck() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        List<Integer> checkerFalse = Arrays.asList(123, 123, 123, 123, 123);

        arr.addAll(Arrays.asList(123,123,333,123));
        arr.removeAll(checkerFalse);
        assertFalse(arr.containsAll(checkerFalse));
    }

    @Test
    public void retainAllCheck() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        List<Integer> checkerFalse = Arrays.asList(123, 123, 123, 123, 123);
        List<Integer> checkerTrue = Arrays.asList(5, 101);

        arr.addAll(Arrays.asList(0, 99, 123, 5, 101));
        arr.retainAll(checkerTrue);
        assertFalse(arr.containsAll(checkerFalse));
        assertTrue(arr.containsAll(checkerTrue));
    }

    @Test
    public void toArrayObjectsCheck() {
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        List<Integer> checkerFalse = Arrays.asList(123, 123, 123, 123, 123);
        arr.addAll(Arrays.asList(123,123,123));
        Assertions.assertNotEquals(checkerFalse, Arrays.asList( arr.toArray()));
        Assertions.assertEquals(Arrays.asList(arr.toArray()), Arrays.asList(123,123,123));
    }
}