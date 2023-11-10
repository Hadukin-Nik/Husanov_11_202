package org.example;

import com.beust.jcommander.Parameter;

import java.util.List;

public class MathCalculator {

    private static double factorial(int n) {
        long ans = 1;
        while(n > 1) {
            ans *= n;
            n--;
        }

        return  ans;
    }
    private static double power(int n, int k) {
        long ans = 1;

        while(k > 0) {
            ans *= n;
            k--;
        }

        return ans;
    }
    @Parameter
    public static double placements_no_repetitions(int n, int k) {
        return factorial(n)/factorial(n - k);
    }
    public static double permutations_no_repetitions(int n) {
        return factorial(n);
    }
    public static double combinations_no_repetitions(int n, int k) {
        return factorial(n)/factorial(k)*factorial(n - k);
    }
    public static double placements_with_repetitions(int n, int k) {
        return power(n, k);
    }
    public static double permutations_with_repetitions(List<Integer> elements) {
        int n = 0;
        for(int k : elements) {
            n += k;
        }
        long buttom = 1;
        for(int k : elements) {
            buttom *= factorial(k);
        }

        return 1.0 * factorial(n) / buttom;
    }
    public static double combinations_with_repetitions(int n, int k) {
        return combinations_no_repetitions(n + k - 1, n);
    }

    public static double first_urn_model(int n, int k, int m) {
        return combinations_no_repetitions(m,k)/combinations_no_repetitions(n, k);
    }
    public static double second_urn_model(int n, int k, int m, int r) {
        return (combinations_no_repetitions(m, r) * combinations_no_repetitions(n - m, k - r)) / combinations_no_repetitions(n, k);
    }

}
