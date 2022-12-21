//Strategy pattern

public class SpiderMine extends Rifle, ITimer {
	Timer myTimer;

	public void setTime(double currentTime, double addableTimer) {
		myTimer.setTime(currentTime, addableTimer);
	}
}