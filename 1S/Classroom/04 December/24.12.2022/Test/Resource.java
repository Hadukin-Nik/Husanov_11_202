public class Resource {
    private final double EPS = 0.00000001;

    private String name;

    private double volume;
    private double price;

    public boolean equals(Resource other) {
        if (name.equals(other.name) && volume - other.volume < EPS) {
            return true;
        }

        return false;
    }


}
