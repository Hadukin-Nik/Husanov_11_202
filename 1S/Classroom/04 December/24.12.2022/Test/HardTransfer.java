//Like Trains, plains and smt like this
public class HardTransfer extends ResourceTransfer{
    private Station start;
    private Station end;

    private double priceOfFuel;

    @Override
    public void unload() {
        end.loadResources(resources);
    }

    public void setPriceOfFuel(double a) {
        priceOfFuel = a;
    }

    public double calculatePrice() {
        return 2 * (start.getLocation().getDistance(end.getLocation()) * priceOfFuel);
    }

    public void Start() {};
    public void Stop() {};

}
