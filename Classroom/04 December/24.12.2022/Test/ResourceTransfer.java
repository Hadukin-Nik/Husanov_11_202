public abstract class ResourceTransfer {
    Resource[] resources;

    public void load(Resource[] recources) {
        this.resources = recources;
    }

    public void unload() {
        this.resources = null;
    }
}
