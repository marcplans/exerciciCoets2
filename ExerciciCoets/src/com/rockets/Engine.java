package com.rockets;

import java.util.ArrayList;
import com.rockets.tools.Tools;

public class Engine extends Thread {
	private final int maximumPower;
	private int currentPower;
	private int accelerations;
	private ArrayList<Integer> prevPowers;
	
//	private volatile ArrayList<Integer> prevPowers;

	// Constructors
	public Engine(int maximumPower) {
		this.maximumPower = Tools
				.roundToClosestTenDivisor(maximumPower);
		currentPower = 0;
		accelerations = 0;
		prevPowers = new ArrayList<Integer>();
	}

	public Engine(int maximumPower, int currentPower) {
		this.maximumPower = maximumPower;
		this.currentPower = currentPower;
		accelerations = 0;
		prevPowers = new ArrayList<Integer>();
	}

	public Engine(int maximumPower, int currentPower,
			int accelerations) {
		this.maximumPower = maximumPower;
		this.currentPower = currentPower;
		this.accelerations = accelerations;
		prevPowers = new ArrayList<Integer>();
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

	public int getAccelerations() {
		return accelerations;
	}

	public void setAccelerations(int accelerations) {
		this.accelerations = accelerations;
	}

	public ArrayList<Integer> getPrevPowers() {
		return prevPowers;
	}

	// Returns a new engine with same maximum and current power as the
	// given one, and an empty prevPowers ArrayList and 0
	// accelerations
	public Engine cloneEngine() {
		return new Engine(getMaximumPower(), getCurrentPower());
	}

	// Method to increase or decrease by 10 current engine power,
	// depending if acceleration is positive ore negative
	public void speedUpDown() {
		int accelerationSign = getAccelerations()
				/ Math.abs(getAccelerations());
		setCurrentPower(getCurrentPower() + accelerationSign * 10);
	}

	@Override
	public void run() {
		getPrevPowers().add(getCurrentPower());
		for (int i = 0; i < Math.abs(getAccelerations()); i++) {
			speedUpDown();
			getPrevPowers().add(getCurrentPower());
		}
	}

}
