package com.rockets;

import java.util.ArrayList;
import com.rockets.tools.Tools;

public class Engine2 extends Thread {
	private final int maximumPower;
	private int currentPower;
	private int currentAcceleration;

	// Constructors
	public Engine2(int maximumPower) {
		this.maximumPower = Tools
				.roundToClosestTenDivisor(maximumPower);
		currentPower = 0;
	}

	public Engine2(int maximumPower, int currentPower) {
		this.maximumPower = maximumPower;
		setCurrentPower(currentPower);
	}

	// Getters and setters
	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		if (currentPower < -getMaximumPower()) {
			this.currentPower = -getMaximumPower();
		} else if (currentPower > getMaximumPower()) {
			this.currentPower = getMaximumPower();
		} else {
			this.currentPower = currentPower;
		}
	}

	public int getMaximumPower() {
		return maximumPower;
	}

	public int getCurrentAcceleration() {
		return currentAcceleration;
	}

	public void setCurrentAcceleration(int currentAcceleration) {
		this.currentAcceleration = currentAcceleration;
	}

	// Returns a new engine with same maximum and current power as the
	// given one, and an empty prevPowers ArrayList and 0
	// accelerations
	public Engine2 cloneEngine() {
		return new Engine2(getMaximumPower(), getCurrentPower());
	}

	@Override
	public void run() {
		setCurrentPower(
				getCurrentPower() + getCurrentAcceleration() * 10);
	}

}
