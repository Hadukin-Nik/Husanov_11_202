package testBase;

public class User {
    private String name;
    private String lastName;

    private String town;

    private int year;

    private int id;


    public User(String lastName, int year, int id) {
        this.lastName = lastName;
        this.year = year;

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTown() {
        return town;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

}
