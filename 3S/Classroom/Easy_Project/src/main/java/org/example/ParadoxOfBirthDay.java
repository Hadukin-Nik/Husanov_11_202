package org.example;

public class ParadoxOfBirthDay {
    public ParadoxOfBirthDay() {}

    public float calculateBirthday(int people) {
        return calculateString(people, 365);
    }

    public float calculateString(int people, int countOfLetter) {
        float ans = 0;
        for(float i = 1; i <= people; i++) {
            ans*=(1 - i / countOfLetter);
        }

        return 1 - ans;
    }
}
