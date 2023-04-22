package org.example;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Test {
    private static final int countOfQuestions = 48;
    private int id;
    private int time;
    private List<Boolean> isCorrect;

    private int score;

    public Test() {
    }

    public void loadData(String filePathUsedTest, List<Integer> answers) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePathUsedTest));
            id = dataInputStream.readByte();

            for(int i = 0; i < countOfQuestions; i += 4) {
                byte buf = dataInputStream.readByte();

                for(int j = 0; j < 4; j++) {
                    int index = i * 4 + j;

                    int ans = (buf>>2*(4 - (j + 1))) & ((1 << 2) - 1);
                    isCorrect.add((ans == answers.get(index)));
                    score += ((ans == answers.get(index)) ? 1 : 0);
                }
            }
            time = dataInputStream.readInt();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public List<Boolean> getIsCorrect() {
        return isCorrect;
    }
}
