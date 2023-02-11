import time.*;

public class Task2a {
    public static void main(String[] args) {
        Time time = new Time(3735);
        Time time1 = new Time(7235);

        try {
            Time t = new Time(30, 20, 40);
        } catch(Exception e) {
            System.out.println("Time signature is incorrect");
        }

        System.out.println(time1);
    }
}
