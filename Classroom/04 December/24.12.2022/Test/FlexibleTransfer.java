public class FlexibleTransfer extends ResourceTransfer{
    private String name;
    Station[] stations;

    public void swapToStations(int i, int j) {
        Station buf = stations[i];
        stations[i] = stations[j];
        stations[j] = buf;
    }

    public void addAStation(Station station) {
        Station[] ans = new Station[stations.length + 1];

        for (int i =0; i < stations.length; i++) {
            ans[i] = stations[i];
        }

        ans[stations.length] = station;
        stations = ans;
    }
}
