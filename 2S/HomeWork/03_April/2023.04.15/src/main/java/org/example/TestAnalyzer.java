package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAnalyzer {
    private static final int countOfQuestions = 48;
    private static final double boundOfGoodStundent = countOfQuestions * 1.0 / 3 * 2;
    private List<Test> tests;
    private List<Question> question;

    private Map<Integer, Boolean> isStudentStrong;

    private int countOfGoodStudents;
    private int countOfBadStudents;
    
    private int countOfAllStudents;

    public TestAnalyzer(TestMaker originalTestWithPushedQuestions, String filepathAndNameOfFile, int countOfTests) {
        tests = new ArrayList<>();
        question = new ArrayList<>();

        isStudentStrong = new HashMap<>();

        List<Integer> answers = originalTestWithPushedQuestions.getCorrectAnswer();

        for(int i = 0; i < countOfQuestions; i++) {
            question.add(new Question(i));
        }

        for(int i = 1; i <= countOfTests; i++) {
            String toadd = "";
            if(i < 10) {
                toadd = "0" + i;
            } else {
                toadd = "" + i;
            }

            Test test = new Test();
            test.loadData(filepathAndNameOfFile + toadd + ".data", answers);
            tests.add(new Test());
            boolean isStudentGood = test.getScore() >= boundOfGoodStundent;
            isStudentStrong.put(test.getId(), isStudentGood);

            if(isStudentGood) {
                countOfGoodStudents ++;
            } else {
                countOfBadStudents ++;
            }

            for(int j = 0; j < question.size(); j++) {
                if(isStudentGood){
                    question.get(j).addGoodStudentId(test.getIsCorrect().get(j));
                } else {
                    question.get(j).addBadStudentId(test.getIsCorrect().get(j));
                }
            }
        }
        
        countOfAllStudents = countOfBadStudents + countOfGoodStudents;
    }

    public int easisestOne() {
        int ans = 0;
        double countOfCorrect = question.get(0).indexOfEasiness();

        for(int i = 1; i < countOfQuestions; i++) {
            if(countOfCorrect < question.get(i).indexOfEasiness()) {
                countOfCorrect = question.get(i).indexOfEasiness();
                ans = i;
            }
        }

        return question.get(ans).getId();
    }
    
    public int hardestOne() {
        int ans = 0;
        double countOfCorrect = question.get(0).indexOfEasiness();

        for(int i = 1; i < countOfQuestions; i++) {
            if(countOfCorrect > question.get(i).indexOfEasiness()) {
                countOfCorrect = question.get(i).indexOfEasiness();
                ans = i;
            }
        }

        return question.get(ans).getId();
    }
    
    public int theHighestScore() {
        int maxScore = tests.get(0).getScore();

        for(int i = 1; i < countOfAllStudents; i++) {
            if(maxScore < tests.get(i).getScore()) {
                maxScore = tests.get(i).getScore();
            }
        }

        return maxScore;
    }

    public int theLowestScore() {
        int minScore = tests.get(0).getScore();

        for(int i = 1; i < countOfAllStudents; i++) {
            if(minScore > tests.get(i).getScore()) {
                minScore = tests.get(i).getScore();
            }
        }

        return minScore;
    }

    public int fastestSolution() {
        int minTime = tests.get(0).getScore();

        for(int i = 1; i < countOfAllStudents; i++) {
            if(minTime > tests.get(i).getTime()) {
                minTime = tests.get(i).getScore();
            }
        }

        return minTime;
    }

    public int slowestSolution() {
        int maxTime = tests.get(0).getScore();

        for(int i = 1; i < countOfAllStudents; i++) {
            if(maxTime < tests.get(i).getTime()) {
                maxTime = tests.get(i).getScore();
            }
        }

        return maxTime;
    }

    public List<Question> getQuestions() {
        return question;
    }

}
