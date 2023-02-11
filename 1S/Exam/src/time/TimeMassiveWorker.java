package time;
public class TimeMassiveWorker {
    public static Time biggestTime(Time[] a) {
        Time ans = a[0];

        for (int i = 1; i < a.length; i++){
            if (ans.isEarlier(a[i])) {
                ans = a[i];
            }
        }

        return ans;
    }

    public static boolean isTwoTimesEquals(Time[] a) {
        boolean ans = false;

        for (int i = 0; i < a.length && !ans; i++) {
            for (int j = i + 1; j < a.length && !ans; j++) {
                ans = a[i].equals(a[j]);
            }
        }

        return ans;
    }
}
