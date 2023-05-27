package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataBase {
    private List<User> users;

    public DataBase() {
        users = new ArrayList<>();
    }

    public void readFromCSV(String csvFile) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] line;


        try {
            line = reader.readNext();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!((line = reader.readNext()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            users.add(new User(line[0], line[1], Integer.valueOf(line[2]), line[3], line[4], line[5], (line[6].equals("YES")), line[7]));
        }
    }
    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    public void returnAsCSV(String csvFile) {
        FileWriter fw;
        CSVWriter csvWriter;

        try {
            fw = new FileWriter(new File(csvFile));
            csvWriter = new CSVWriter(fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(var user : users){
            String collect = Stream.of(user.getStrings())
                    .map((List<String> data) -> escapeSpecialCharacters(data.toString()))
                    .collect(Collectors.joining(","));
            try {
                fw.write(collect);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void readFromJSON(String jsonFile) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Scanner sc;
        Gson gson = gsonBuilder.create();
        try {
            FileReader fileReader = new FileReader(new File(jsonFile));

            sc = new Scanner(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNextLine()) {
            String jsonString = sc.nextLine();

            if(jsonString.length() <= 5) {
                continue;
            }

            users.add(gson.fromJson(jsonString, User.class));
        }
    }

    public void returnAsJSON(String file) {
        Gson gson = new Gson();
        FileWriter fw;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (var user : users) {
            gson.toJson(user, fw);
            try {
                fw.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void csvConverToJson(String scv, String json) {
        readFromCSV(scv);
        returnAsJSON(json);
    }

    public void jsonConvertToCSV(String json, String csv) {
        returnAsJSON(json);
        returnAsCSV(csv);
    }
}
