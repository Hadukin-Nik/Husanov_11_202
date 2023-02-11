//Strategy pattern

public class Mine extends Weapon, ITimer {
	Timer myTimer;

	public void setTime(double currentTime, double addableTimer) {
		myTimer.setTime(currentTime, addableTimer);
	}
}