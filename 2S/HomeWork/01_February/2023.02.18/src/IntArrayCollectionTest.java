import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayCollectionTest {
    @Test
    public void containsAndAddCheck() {
        IntArrayCollection arr = new IntArrayCollection(10);

        arr.add(5);

        assertTrue(arr.contains(5));
    }
    @Test
    public void sizeTest() {
        IntArrayCollection arr = new IntArrayCollection();
        arr.add(5);

        Assertions.assertEquals("1", arr.size());
    }

    @Test
    public void removeTest() {
        IntArrayCollection arr = new IntArrayCollection();
        arr.add(5);

        arr.remove(5);
        assertTrue(arr.contains(5));
    }

    @Test
    public void addOverCapacity() {
        IntArrayCollection arr = new IntArrayCollection();
        arr.add(5);

        for (int i = 0; i < 100; i++) {
            arr.add(i);
            System.out.println(arr.size());
        }
        assertTrue(arr.size() >= 100 + 1);
    }
}