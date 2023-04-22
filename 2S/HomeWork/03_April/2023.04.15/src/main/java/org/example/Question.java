package org.example;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private int countOfCorrectGoodStudent;
    private int countOfCorrectBadStudent;

    private int countOfUnCorrectGoodStudent;
    private int countOfUnCorrectBadStudent;

    private int allStudents;

    public Question(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addGoodStudentId(boolean isCorrect) {
        if(isCorrect) {
            countOfCorrectGoodStudent ++;
        } else {
            countOfUnCorrectGoodStudent ++;
        }
        allStudents++;
    }

    public void addBadStudentId(boolean isCorrect) {
        if(isCorrect) {
            countOfCorrectBadStudent ++;
        } else {
            countOfUnCorrectBadStudent ++;
        }
        allStudents++;
    }

    public double indexOfEasiness() {
        return (countOfCorrectBadStudent + countOfCorrectGoodStudent) / allStudents;
    }

    public double indexOfDescrimination() {
        return countOfCorrectGoodStudent / (countOfCorrectGoodStudent + countOfUnCorrectGoodStudent)
                - countOfCorrectBadStudent/(countOfCorrectBadStudent + countOfUnCorrectBadStudent);
    }
}

