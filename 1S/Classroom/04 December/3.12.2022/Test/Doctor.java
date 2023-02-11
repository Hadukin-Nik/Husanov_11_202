public abstract class Doctor {
	private String name;

	public void healing(Patient patient, Medicine medicine) {
		patient.setHealth(patient.getHealth() + medicine.getPower());
	}

	public void killing(Patient patient, Medicine medicine) {
		patient.setHealth(patient.getHealth() - medicine.getPower());
	}

	public void useMedicine();
	
	public abstract String talk();
}