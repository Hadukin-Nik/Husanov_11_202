package com.example.agario.helpers;

public class EasyCalculator {
    private static final double EPS = 0.0001;

    public static double getRoot(double a) {
        if(a < 0){
            throw new ArithmeticException();
        }

        double l = 0;
        double r = a;

        while(r - l > EPS) {
            double m = (r + l)/2;
            if(m * m > a) {
                r = m;
            } else {
                l = m;
            }
        }

        return l;
    }
}
