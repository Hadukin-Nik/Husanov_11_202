package org.example;

public class DishString extends FoodString{
    private String discription;

    public DishString() {
        super();
    }

    public DishString(String name, int cost) {
        super(name, cost);
    }

    public DishString(String name, String discription, int cost) {
        super(name, cost);

        this.discription = discription;
    }

    public String getDiscription() {
        return discription;
    }

}
