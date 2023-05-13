package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataAnalytic dataAnalytic = new DataAnalytic("src/main/BirthsKingCounty2001.txt");

        dataAnalytic.createNewDataSet("src/main/BirthsConverted.txt");
        Map<Integer, Double> ma1 = dataAnalytic.getYearsOfEducationByChildrens();
        boolean answer = dataAnalytic.isIdeaTrue();
        List<BirthData> db = dataAnalytic.getDataFromNewDataSet("src/main/BirthsConverted.txt");

        for(var i: db) {
            System.out.println("Sex: " + (i.isMale() ? "M" : "F") + " isMarried: " + (i.isMarried() ? "Y" : "N") + " " + i.getTimeOfPregnancy());
        }
    }
}