import java.util.Comparator;

public class Comparator04 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        long a1 = (long) Math.pow(10, length(o1));
        long a2 = (long) Math.pow(10, length(o2));

        while(a1 >= 1 && a2 >= 1) {
            if(o1 / a1 > o2 / a2) {
                return 1;
            } else if (o1 / a1 < o2 / a2) {
                return -1;
            }
            a1 /= 10;
            a2 /= 10;
        }

        if (length(o1) == length(o2)) {
            return 0;
        } else if (length(o1) > length(o2)) {
            return 1;
        } else {
            return -1;
        }
    }

    private int length(int a) {
        a = Math.abs(a);
        int ans = 1;
        long b = 10;
        while(b <= a) {
            ans ++;
            b *= 10;
        }

        return ans;
    }
}
