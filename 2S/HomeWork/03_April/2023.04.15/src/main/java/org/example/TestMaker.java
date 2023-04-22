package org.example;
import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMaker {
    private byte[] ans;
    private List<String> test;
    private long time;

    private byte user;
    private List<Integer> correctAnswer;


    public void mapAnswer(String filePath) {
        try {
            DataOutputStream fw = new DataOutputStream(new FileOutputStream(filePath));

            fw.writeByte(user);
            for(int i = 0; i < ans.length; i++) {
                fw.writeByte(ans[i]);
            }

            fw.writeInt((int) time);

            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void pushQuestions(String filepath, int count) {
        correctAnswer = new ArrayList<>();
        try {
            ans = new byte[count / 4];
            FileReader file = new FileReader(filepath);
            Scanner sc = new Scanner(file);

            test = new ArrayList<>(count * 5);

            for(int i = 0; i < count; i++) {
                String an = sc.nextLine();
                String[] buf = an.split("\t");

                for(int j = 0; j < buf.length - 1; j++) {
                    test.add(buf[j]);
                }

                correctAnswer.add(Integer.valueOf(buf[buf.length - 1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your id?");
        user = (byte)scanner.nextInt();
        System.out.println("Good! \n Now the test starts!");

        long time = System.currentTimeMillis();
        if(test == null) {
            throw new RuntimeException("No Test added");
        }

        byte cur_ans = 0;
        int count = 0;

        for(int i = 0; i < test.size(); i+= 5) {
            System.out.println(test.get(i));

            for(int j = i + 1; j < i + 5; j++) {
                System.out.println("    " + test.get(j));
            }

            cur_ans <<= 2;
            cur_ans |= (byte) (scanner.nextInt() - 1);

            count ++;
            if(count == 4) {
                count = 0;
                ans[((i + 1) / 5) / 4] = cur_ans;

                cur_ans = 0;
            }
        }

        this.time = System.currentTimeMillis() - time;
    }

    public List<Integer> getCorrectAnswer() {
        return correctAnswer;
    }
}
