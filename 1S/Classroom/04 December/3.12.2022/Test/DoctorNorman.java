public class DoctorNorman extends Doctor {
	private Medicine medicine; 

	public String talk() {
		return "I am Doctor Norman";
	}

	public void useMedicine(Patient patient) {
		patient.setHealth(patient.getHealth() + medicine.getPower());
	}

	public void findMedicine() {
		medicine = new Medicine();
	}
}