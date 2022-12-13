package src;

public class ItemRangable {
    private String name;

    private double recomendation;

    ItemRangable() {
        this.name = new String();
        this.recomendation = 0;
    }

    public ItemRangable(String name, double recomendation) {
        this.name = name;
        this.recomendation = recomendation;
    }
    public void addRecomendation(double addable) {
        recomendation += addable;
    }
    public String getName() {
        return name;
    }

    public double getRecomendation() {
        return recomendation;
    }
}
