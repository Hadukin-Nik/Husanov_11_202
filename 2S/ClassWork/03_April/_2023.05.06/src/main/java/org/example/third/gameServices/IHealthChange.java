package org.example.third.gameServices;

public interface IHealthChange {
	public void addMaxHP(double addable);
	public void decMaxHP(double decreasable);

	public void addHP(double addable);
	public void decHP(double decreasable);
}