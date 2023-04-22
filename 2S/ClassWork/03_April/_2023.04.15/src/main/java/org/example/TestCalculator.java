package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCalculator {
    private List<Test> tests;
    public TestCalculator(String inputAd, int countOfQuestions) {
        File inputData = new File(inputAd);

        List<Test> buf = new ArrayList<>();
        try{
            Scanner sc = new Scanner(inputData);

            while(sc.hasNextLine()) {
                byte[] a;

                int id = sc.nextByte() + sc.nextByte() + sc.nextByte() + sc.nextByte();
                for(int i = 0; i < countOfQuestions / 4; i++) {

                }
            }
        } catch (Exception exception) {

        }
    }
}
