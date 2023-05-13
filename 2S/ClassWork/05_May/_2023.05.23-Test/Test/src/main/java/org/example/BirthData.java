package org.example;

public class BirthData {
    private int yearsOfEducation;
    private int countOfChildren;

    private boolean isMarried;

    private int timeOfPregnancy;

    private boolean isMale;

    public BirthData(boolean isMale, int countOfChildren, boolean isMarried, int education, int timeOfPregnancy) {
        this.isMale = isMale;
        this.countOfChildren = countOfChildren;
        this.isMarried = isMarried;
        this.yearsOfEducation = education;
        this.timeOfPregnancy = timeOfPregnancy;
    }

    public BirthData(boolean isMale, boolean isMarried, int timeOfPregnancy) {
        this.isMale = isMale;
        this.isMarried = isMarried;
        this.timeOfPregnancy = timeOfPregnancy;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public int getTimeOfPregnancy() {
        return timeOfPregnancy;
    }

    public boolean isMale() {
        return isMale;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }
}
