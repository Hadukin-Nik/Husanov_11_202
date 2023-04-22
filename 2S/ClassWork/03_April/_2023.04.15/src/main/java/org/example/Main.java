package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TestMaker testMaker = new TestMaker();

        //testMaker.pushQuestions("src/main/java/answers.tsv", 48);

        //testMaker.start();

        //testMaker.mapAnswer("src/main/java/out.data");

        try {
            FileReader fl = new FileReader("src/main/java/out.data");
            Scanner sc = new Scanner(fl);
            int id = fl.read();

            byte[] s = new byte[12];

            for(int i = 0; i < 12; i++) {
                s[i] = (byte) fl.read();
            }

            int time = (byte) fl.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}