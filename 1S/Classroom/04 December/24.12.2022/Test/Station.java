public class Station {
    private Point location;

    private Resource[] resourcesOnBase;

    public void loadResources(Resource[] onLoad) {
        Resource[] ans = new Resource[resourcesOnBase.length + onLoad.length];

        for (int i = 0; i < ans.length; i++) {
            if (i < resourcesOnBase.length) {
                ans[i] = resourcesOnBase[i];
            } else {
                ans[i] = onLoad[i - resourcesOnBase.length];
            }
        }

        resourcesOnBase = ans;
    }

    public Point getLocation() {
        return location;
    }
}
