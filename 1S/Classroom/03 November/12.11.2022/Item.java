public class Item implements IItem {
	private String name;
	private int count;
	private int power;

	public Item() {
		name = "NULL";
		count = 0;
		power = 0;
	}

	public Item(String name, int count, int power) {
		this.name = name;
		this.count = count;
		this.power = power;
	}

	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public int getPower() {
		return power;
	}
	public void setCount(int count) throws Exception {
		if (count < 0) {
			throw new Exception("Count of Items can be less zero!");
		}

		this.count = count;
	}
}