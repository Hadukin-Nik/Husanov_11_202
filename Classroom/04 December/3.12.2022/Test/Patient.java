public class Patient {
	double health;

	double illness;

	public Patient(double illness) {
		health = 100;

		this.illness = illness;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getHealth() {
		return health;
	}

	public String reaction(Doctor d) {
		if (d instanceof DoctorHaus) {
			return "Wow, he will defenetly kill me";
		} else {
			return "Woh, it is not a Doctor Haus";
		}
	}

	public double calculateTimeToDeath() {
		return health \ illness;
	}
}