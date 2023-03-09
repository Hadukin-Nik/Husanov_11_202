import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.ArrayList;

public class ComparatorsTest {
    @Test
    void sort1() {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        a1.addAll(Arrays.asList(3, 2, 1 ,45, -1, 0));
        a2.addAll(Arrays.asList(3, 2, 1 ,45, -1, 0));

        Collections.sort(a1, new StandartComparator());

        Assertions.assertEquals(Arrays.asList(-1, 0, 1,2,3,45), a1);
        Assertions.assertNotEquals(a1, a2);;
    }

    @Test
    void sort2() {
        List<String> a1 = new ArrayList<>();
        List<String> a2 = new ArrayList<>();

        createListString(a1);
        createListString(a2);

        Collections.sort(a1, new Comparator02());

        Assertions.assertEquals(Arrays.asList("ab", "abc", "baba", "cab"), a1);
        Assertions.assertNotEquals(a1, a2);;
    }

    @Test
    void sort3() {
        List<String> a1 = new ArrayList<>();
        List<String> a2 = new ArrayList<>();

        a1.addAll(Arrays.asList("abad", "abad", "abdf", "avcg"));
        a2.addAll(Arrays.asList("abad", "aaad", "abdf", "avcg"));

        Collections.sort(a2, new Comparator03());
        Collections.sort(a1, new Comparator03());
        Assertions.assertEquals(Arrays.asList("abad", "abad", "abdf", "avcg"), a1);
        Assertions.assertEquals(Arrays.asList("aaad", "abad", "abdf", "avcg"), a2);
    }

    @Test
    void sort4() {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        a1.addAll(Arrays.asList(123, 32, 11, 1));
        a2.addAll(Arrays.asList(123, 32, 11, 1));

        Collections.sort(a1, new Comparator04());

        Assertions.assertEquals(Arrays.asList(1, 11, 123, 32), a1);
        Assertions.assertNotEquals(a1, a2);
    }

    @Test
    void sort6() {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        a1.addAll(Arrays.asList(51, 62, 1562, 1242));
        a2.addAll(Arrays.asList(51, 62, 1242, 1562));

        Collections.sort(a1, new Comparator06());
        Collections.sort(a2, new Comparator06());

        Assertions.assertEquals(Arrays.asList(51, 62, 1242, 1562), a1);
        Assertions.assertEquals(a2, a2);
    }
    private void createListString(List<String> a) {
        a.addAll(Arrays.asList("abc", "ab", "cab", "baba"));
    }
}
