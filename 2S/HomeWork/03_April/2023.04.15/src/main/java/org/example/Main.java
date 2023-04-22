package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TestMaker testMaker = new TestMaker();

        testMaker.pushQuestions("src/main/java/answers.tsv", 48);

        /*testMaker.start();

        testMaker.mapAnswer("src/main/java/out.data");*/

        TestAnalyzer ta = new TestAnalyzer(testMaker,"src/Tests/output", 10);

        System.out.println(ta.fastestSolution());
    }
}