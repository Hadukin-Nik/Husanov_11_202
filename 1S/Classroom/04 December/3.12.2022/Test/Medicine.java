public class Madicine{
	String name;
	double power;
	int countOfUsages;

	public double getPower() {
		return power;
	}

	public void useMedicine() {
		countOfUsages --;
	}

	public void addCountOfUsages(int count) {
		countOfUsages += count;
	}

	public String getName() {
		return name;
	}
}