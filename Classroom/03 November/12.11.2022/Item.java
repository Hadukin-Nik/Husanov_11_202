public class Item implements IItem {
	private IItemBehaviour itemBehaviour;
	private String name;

	public Item (String name, IItemBehaviour itemBehaviour) {
		this.name = name;
		this.itemBehaviour = itemBehaviour;
	}

	public getName() {
		return name;
	}

	public useItem() {
		itemBehaviour.useItem();
	}
}	