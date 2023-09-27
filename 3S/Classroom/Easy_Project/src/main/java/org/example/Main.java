package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParadoxOfBirthDay p = new ParadoxOfBirthDay();

        Scanner sc = new Scanner(System.in);

        int employees = sc.nextInt();

        System.out.println(p.calculateBirthday(employees));
    }
}