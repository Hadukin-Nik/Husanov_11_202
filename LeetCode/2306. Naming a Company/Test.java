import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Test {
    public long distinctNames(String[] ideas) {
        HashSet<String> buf = new HashSet<String>(Arrays.asList(ideas));
        long ans = 0;

        HashMap<Character, HashMap<Character, Integer>> preloader = new HashMap<>();

        for (int i = 0; i < ideas.length; i++) {
            if (!preloader.containsKey(ideas[i].charAt(0))) {
                preloader.put(ideas[i].charAt(0), new HashMap<>());
            }

            for (int a = (int)'a'; a <= (int)'z'; a++) {
                StringBuilder sb1 = new StringBuilder(ideas[i]);
                sb1.setCharAt(0, (char) a);

                if (buf.contains(sb1.toString())) {
                    continue;
                }

                if (!preloader.get(ideas[i].charAt(0)).containsKey((char) a)) {
                    preloader.get(ideas[i].charAt(0)).put((char) a, 1);
                } else {
                    preloader.get(ideas[i].charAt(0)).put((char) a, preloader.get(ideas[i].charAt(0)).get((char) a) + 1);
                }
            }
        }


        for (int i = 0; i < ideas.length; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                StringBuilder sb1 = new StringBuilder(ideas[i]);
                sb1.setCharAt(0, j);
                if (buf.contains(sb1.toString())) {
                    continue;
                }

                if(preloader.containsKey(j) && preloader.get(j).containsKey(ideas[i].charAt(0))) {
                    ans += preloader.get(j).get(ideas[i].charAt(0));
                }
            }
        }
        return ans;
    }
}