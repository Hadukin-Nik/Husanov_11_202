import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.ArrayList;

public class ComparatorsTest {
    @Test
    void sort11() {
        List<Integer> a1 = new ArrayList<>();

        a1.addAll(Arrays.asList(3, 2, 1 ,45, -1, 0));

        Collections.sort(a1, new StandartComparator());

        Assertions.assertEquals(Arrays.asList(-1, 0, 1,2,3,45), a1);
    }

    @Test
    void sort12() {
        List<Integer> a = new ArrayList<>();

        a.addAll(Arrays.asList(0, 1));

        Collections.sort(a, new StandartComparator());

        Assertions.assertEquals(Arrays.asList(0, 1), a);
    }

    @Test
    void sort21() {
        List<String> a1 = new ArrayList<>();

        createListString(a1);

        Collections.sort(a1, new Comparator02());

        Assertions.assertEquals(Arrays.asList("ab", "abc", "baba", "cab"), a1);
    }

    @Test
    void sort22() {
        List<String> a1 = new ArrayList<>();

        createListString(a1);

        Collections.sort(a1, new Comparator02());

        Assertions.assertNotEquals(Arrays.asList("abc", "ab", "baba", "cab"), a1);
    }

    @Test
    void sort31() {
        List<String> a1 = new ArrayList<>();

        a1.addAll(Arrays.asList("abad", "abad", "abdf", "avcg"));

        Collections.sort(a1, new Comparator03());
        Assertions.assertEquals(Arrays.asList("abad", "abad", "abdf", "avcg"), a1);
    }

    @Test
    void sort32() {
        List<String> a2 = new ArrayList<>();

        a2.addAll(Arrays.asList("abad", "aaad", "abdf", "avcg"));

        Collections.sort(a2, new Comparator03());

        Assertions.assertEquals(Arrays.asList("aaad", "abad", "abdf", "avcg"), a2);
    }

    @Test
    void sort41() {
        List<Integer> a1 = new ArrayList<>();

        a1.addAll(Arrays.asList(123, 32, 11, 1));

        Collections.sort(a1, new Comparator04());

        Assertions.assertEquals(Arrays.asList(1, 11, 123, 32), a1);
    }

    @Test
    void sort42() {
        List<Integer> a2 = new ArrayList<>();

        a2.addAll(Arrays.asList(01, 10, 1000));

        Collections.sort(a2, new Comparator04());

        Assertions.assertEquals(Arrays.asList(1, 10, 1000), a2);
    }

    @Test
    void sort51() {
        List<String> a1 = new ArrayList<>();

        a1.addAll(Arrays.asList("a", "ab", "cab", "bac", "back"));

        Collections.sort(a1, new Comparator05());

        Assertions.assertEquals(Arrays.asList("a", "ab", "cab", "bac", "back"), a1);
    }

    @Test
    void sort52() {
        List<String> a1 = new ArrayList<>();

        a1.addAll(Arrays.asList("ab", "a", "baba", "cab"));

        Collections.sort(a1, new Comparator05());

        Assertions.assertEquals(Arrays.asList("a", "ab", "cab", "baba"), a1);
    }

    @Test
    void sort61() {
        List<Integer> a1 = new ArrayList<>();

        a1.addAll(Arrays.asList(51, 62, 1562, 1242));

        Collections.sort(a1, new Comparator06());

        Assertions.assertEquals(Arrays.asList(51, 62, 1242, 1562), a1);
    }

    @Test
    void sort62() {
        List<Integer> a2 = new ArrayList<>();

        a2.addAll(Arrays.asList(51, 62, 1242, 1562));

        Collections.sort(a2, new Comparator06());

        Assertions.assertEquals(Arrays.asList(51, 62, 1242, 1562), a2);
    }
    private void createListString(List<String> a) {
        a.addAll(Arrays.asList("abc", "ab", "cab", "baba"));
    }
}
