import java.util.Comparator;

public class Comparator06 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        long a = 1;
        long b = 1;

        while(a < o1 && b < o2) {
            if(o1 % a > o2 % b) {
                return 1;
            } else if (o1 % a < o2 % b) {
                return -1;
            }

            a *= 10;
            b *= 10;
        }

        if (o1 == o2) {
            return 0;
        } else if (o1 > o2) {
            return 1;
        } else {
            return -1;
        }
    }
}
