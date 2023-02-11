package entities.inventoryEntities;


public class Inventory implements IInventory {
	private final int MAX_COUNT = 10000;

	private IItem[] items;

	public Inventory() {
		this.items = new Item[MAX_COUNT];
	}

	public Inventory(IItem[] items) {
		this.items = items;
	}


	public String getNameOfItem(int id) throws Exception {
		if (id >= items.length) {
			throw new Exception("id of item is out of range");
		} else {
			return items[id].getName();
		} 
	}


	public int getCountOfItem(int id) throws Exception {
		if (id >= items.length) {
			throw new Exception("id of item is out of range");
		} else {
			return items[id].getCount();
		} 
	}
	public int getPowerOfItem(int id) throws Exception {
		if (id >= items.length) {
			throw new Exception("id of item is out of range");
		} else {
			return items[id].getPower();
		} 
	}

	public int getCountOfItems() {
		return items.length;
	}

	public void setCountOfItems(int id, int newCount) throws Exception {
		if (id >= items.length) {
			throw new Exception("id of item is out of range");
		} else {
			items[id].setCount(newCount);
		} 
	}


}