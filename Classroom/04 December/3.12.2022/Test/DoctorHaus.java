public class DoctorHaus extends Doctor {
	private final double uknownPowerOfMovie = 10000000000;

	public DoctorHaus() {
		this.name = "DoctorHaus";
	}

	public void killing(Patient patient, Medicine medicine) {
		patient.setHealth(patient.getHealth() + medicine.getPower() * uknownPowerOfMovie);
	}

	public String talk() {
		return "I'am the greater DoctorHaus"
	}
}