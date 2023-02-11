package ru.kpfu.services;

public class StringHelper {
    public static String toString(int[] a) {
        String ans = new String();

        for (int i = 0; i < a.length; i++) {
            ans = ans + a[i];
        }


        return ans;
    }

    public static int[] stringToIntReverse(String a) {
        int[] ans = new int [a.length()];

        for (int i = 0; i < a.length(); i++) {
            ans[i] = a.charAt(a.length() - i - 1) - '0';
        }

        return ans;
    }
}
