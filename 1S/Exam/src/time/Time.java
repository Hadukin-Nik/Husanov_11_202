package time;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    public Time(int seconds) {
        this.hours = seconds / 3600;
        this.minutes = seconds % 3600 / 60;
        this.seconds = seconds % 60;
    }
    public Time(int hours, int minutes, int seconds) throws Exception {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        if (hours >= 24 || minutes >= 60 || seconds >= 60) {
            throw new Exception();
        }
    }

    public int getInSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }
    public int distanceInSeconds(Time other) {
        int answer = getInSeconds() - other.getInSeconds();

        return (answer < 0 ? answer * (-1) : answer);
    }

    public Time distanceInTime(Time other) {
        int timeInSeconds = distanceInSeconds(other);

        return new Time(timeInSeconds);
    }

    public boolean isEarlier(Time other) {
        if (other.getInSeconds() < getInSeconds()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String hours = "", minutes = "", seconds = "";
        if (this.hours < 10) {
            hours = "0";
        }
        hours += this.hours;

        if (this.minutes < 10) {
            minutes = "0";
        }
        minutes += this.minutes;

        if (this.seconds < 10) {
            seconds = "0";
        }
        seconds += this.seconds;

        return hours + ":" + minutes + ":" + seconds;
    }

    public boolean equals(Time other) {
        return (getInSeconds() == other.getInSeconds());
    }
}
