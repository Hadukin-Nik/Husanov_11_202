package src;

import src.user.User;
import src.user.UserRecommendation;

public class MainEnter {
    public static void main(String[] args) {
        User me = new User("Nikolay");

        UsersData usersData = new UsersData();

        try {
            usersData.getDataFromFile("users.txt");
        } catch (Exception exception) {
            System.out.println("Smt goes wrons=g");
        }

        ItemsData filmsData = new ItemsData();

        try {
            filmsData.getDataFromFile("films.txt");
        } catch (Exception exception) {
            System.out.println("Smt goes wrons=g");
        }

        me = usersData.findUserByName("Nikolay");

        UserRecommendation userRecommendation = new UserRecommendation(filmsData.getItems(), me, 0.50);

        userRecommendation.createList(usersData.getUsers());

        System.out.println(userRecommendation.getStringOfEquality());

        System.out.println(userRecommendation);

    }
}
