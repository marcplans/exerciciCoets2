package com.rockets;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.sql.rowset.Joinable;

import com.rockets.tools.Tools;

public class Rocket2 {
	String rocketId;
	ArrayList<Engine2> rocketEngines;
	double currentSpeed;

	// Constructor
	public Rocket2(String rocketId) {
		this.rocketId = rocketId.toUpperCase();
		rocketEngines = new ArrayList<>();
		currentSpeed = 0;
	}

	// Getters and setters
	public String getRocketId() {
		return rocketId;
	}

	public void setRocketId(String rocketId) {
		this.rocketId = rocketId.toUpperCase();
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public ArrayList<Engine2> getRocketEngines() {
		return rocketEngines;
	}

	public void setRocketEngines(ArrayList<Engine2> rocketEngines) {
		this.rocketEngines = rocketEngines;
	}

	public void setRocketEngines(int... enginePowers) {
		rocketEngines.clear();
		for (int power : enginePowers) {
			rocketEngines.add(new Engine2(power));
		}
	}

	// Returns a new ArrayList of cloned engines from the current
	// rocket engines ArrayList
	public ArrayList<Engine2> cloneEngines() {
		ArrayList<Engine2> output = new ArrayList<>();
		for (int i = 0; i < numberOfEngines(); i++) {
			output.add(getEngineByIndex(i).cloneEngine());
		}
		return output;
	}

	// Returns rocket number of engines
	public int numberOfEngines() {
		return getRocketEngines().size();
	}

	// Returns engine from engines ArrayList by index position
	public Engine2 getEngineByIndex(int index) {
		if (index < numberOfEngines()) {
			return getRocketEngines().get(index);
		}
		return null;
	}

	// Sets a given number of accelerations and starts rocket engines
	public void runEngines(int accelerations) {

		for (int i = 0; i < numberOfEngines(); i++) {
			getEngineByIndex(i).setCurrentAcceleration(
					accelerations / Math.abs(accelerations));
			getEngineByIndex(i).start();

			try {
				getEngineByIndex(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.print(toStringEnginePower());
		setRocketEngines(cloneEngines());

	}
	
	
//	public void runEngines(int accelerations) {
//		for (int i = 0; i < Math.abs(accelerations); i++) {
//			for (int j = 0; j < numberOfEngines(); j++) {
//				getEngineByIndex(j).setCurrentAcceleration(
//						accelerations / Math.abs(accelerations));
//				getEngineByIndex(j).start();
//				
//				try {
//					getEngineByIndex(j).join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//			System.out.println(toStringEnginePower());
//			setRocketEngines(cloneEngines());
//		}
//
//	}

	// Sets a given number of accelerations and starts rocket engines
//	public void StartEngines(int accelerations) {
//		for (int i = 0; i < numberOfEngines(); i++) {
//			getEngineByIndex(i).setAccelerations(accelerations);
//			getEngineByIndex(i).start();
//		}
//	}

	// Returns rocket updated speed taking as argument powers in
	// prevPowers ArrayList at given position index. Updated speed
	// is current speed plus the corresponding speed increment
//	public double updateSpeed(int currentPowerIndex) {
//		double output = getCurrentSpeed();
//		double totalPower = 0;
//		for (int i = 0; i < numberOfEngines(); i++) {
//			totalPower += getEngineByIndex(i).getPrevPowers()
//					.get(currentPowerIndex);
//		}
//		int speedSign = (int) (totalPower / Math.abs(totalPower));
//
//		output += speedSign * 100 * Math.sqrt(Math.abs(totalPower));
//		return Tools.myRound(output, 2);
//	}

	// Returns true if all rocket engines prevPowers array is
	// large enough to provide next set of powers to be printed out
//	public boolean isReadyToPrint(int currentPowerIndex) {
//		for (Engine engine : getRocketEngines()) {
//			if (engine.getPrevPowers().size() < currentPowerIndex
//					+ 1) {
//				return false;
//			}
//		}
//		return true;
//	}

	// Returns a string with rocket id and the number of engines
	public String toStringPhase1() {
		return getRocketId() + ": " + numberOfEngines() + " engines";
	}

	// Returns a string with rocket id and max power of its engines
	public String toStringPhase2() {
		String output = getRocketId() + ": ";
		for (int i = 0; i < numberOfEngines(); i++) {
			output += getEngineByIndex(i).getMaximumPower();
			output += (i == numberOfEngines() - 1) ? "" : ",";
		}
		return output;
	}

	// Returns a string with rocket id and its current speed
	public String toStringCurrentSpeed() {
		DecimalFormat myFormat = new DecimalFormat("0.00");
		return getRocketId() + " current speed: "
				+ myFormat.format(getCurrentSpeed());
	}

	// Returns formatted string to print rocket engines powers and
	// speed
	public String toStringEnginePower() {
		String output = "[";
		DecimalFormat myFormat = new DecimalFormat("0.00");
		for (int i = 0; i < numberOfEngines(); i++) {
			output += Tools.formatNum(
					"" + getEngineByIndex(i).getCurrentPower(), 3);
			output += (i == numberOfEngines() - 1) ? "]" : ", ";
		}
		return output + "   " + Tools
				.formatNum(myFormat.format(getCurrentSpeed()), 8);
	}

}
