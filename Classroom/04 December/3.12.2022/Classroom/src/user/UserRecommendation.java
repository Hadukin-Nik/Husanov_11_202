package src.user;

import src.FilmRangable;

public class UserRecommendation {
    private User whomRecommend;

    private UserRangable[] listOfRecommenations;
    private String[] films;
    private double equalityBound;

    public UserRecommendation(String[] films, User whomRecommend, double equalityBound) {
        this.whomRecommend = whomRecommend;
        this.equalityBound = equalityBound;
        this.films = films;
    }

    private double compare(User a, User b) {
        double count = 0;

        boolean[] firstSet = a.getFilmsAreeable();
        boolean[] secondSet = b.getFilmsAreeable();

        for (int i = 0; i < firstSet.length; i++) {
            if (firstSet[i] && secondSet[i]) {
                count += 1;
            }
        }

        double sum = a.getCountOfPos() + b.getCountOfPos();

        return (2 * (count)) / sum;
    }

    public void createList(User[] users) {
        listOfRecommenations = new UserRangable[users.length];

        for(int i = 0; i < users.length; i++) {
            listOfRecommenations[i] = new UserRangable(users[i], whomRecommend, compare(users[i], whomRecommend));
        }

        for (int i = 0; i < listOfRecommenations.length; i++) {
            for (int j = 0; j < listOfRecommenations.length - 1; j++) {
                if (listOfRecommenations[j].getEquality() < listOfRecommenations[j + 1].getEquality()) {
                    UserRangable buf = listOfRecommenations[j];
                    listOfRecommenations[j] = listOfRecommenations[j + 1];
                    listOfRecommenations[j + 1] = buf;
                }
            }
        }
    }
    public String getStringOfEquality() {
        String ans = "";

        for (int i = 0; i < listOfRecommenations.length; i++) {
            ans += listOfRecommenations[i].getMe().getName() + " equality: " + (int)(listOfRecommenations[i].getEquality() * 100) + "%" + "\n";
        }

        return ans;
    }

    public void setEqualityBound(double equalityBound) {
        this.equalityBound = equalityBound;
    }

    @Override
    public String toString() {
        String ans = "Recommend for you: \n";
        FilmRangable[] filmsRangable = new FilmRangable[films.length];

        for (int i = 0; i < films.length; i++) {
            filmsRangable[i] = new FilmRangable(films[i], 0);
        }

        for (int i = 1; i < listOfRecommenations.length; i++) {
            UserRangable userRangable = listOfRecommenations[i];

            if (userRangable.getEquality() >= equalityBound) {
                boolean[] my = whomRecommend.getFilmsAreeable();
                boolean[] others = userRangable.getMe().getFilmsAreeable();

                for (int j = 0; j < my.length; j++) {
                    if (!my[j] && others[j]) {
                        filmsRangable[j].addRecomendation(1 * userRangable.getEquality());
                    }
                }
            }
        }



        for (int i = 0; i < filmsRangable.length; i++) {
            for (int j = 0; j < filmsRangable.length - 1; j++) {
                if (filmsRangable[j].getRecomendation() < filmsRangable[j + 1].getRecomendation()) {
                    FilmRangable buf = filmsRangable[j];
                    filmsRangable[j] = filmsRangable[j + 1];
                    filmsRangable[j + 1] = buf;
                }
            }
        }

        for (int i = 0; i < filmsRangable.length; i++) {
            if (filmsRangable[i].getRecomendation() > 0) {
                ans += "\"" + filmsRangable[i].getName() + "\"" + " with score: " + filmsRangable[i].getRecomendation() + "\n";
            }
        }

        return ans;
    }
}
