package org.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "src/main/data.json";
        DataBase db =  new DataBase();
        db.readFromJSON(csvFile);
        DataBaseWorker dataBaseWorker = new DataBaseWorker(db, "src/main/");
        dataBaseWorker.command("/user/search?q=2004&format=HTML");
    }
}