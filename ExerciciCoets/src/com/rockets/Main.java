package com.rockets;

import com.rockets.tools.Tools;

public class Main {

	public static void main(String[] args) {

		// Initialize rockets
		Rocket rocket1 = new Rocket("32WESSDS");
		Rocket rocket2 = new Rocket("LDSFJA32");
		rocket1.setRocketEngines(10, 30, 80);
		rocket2.setRocketEngines(30, 40, 50, 50, 30, 10);
//		rocket1.setRocketEngines(10, 30, 80, 50, 30, 10, 70, 90, 80, 50, 30, 10, 70, 90, 80);
//		rocket2.setRocketEngines(30, 40, 50, 50, 30, 10, 70, 90, 80, 50, 30, 10, 70, 90, 80);

		// Phase1 & 2
		printPhase1and2(rocket1, rocket2);

		// Phase3
		System.out.println("\nPhase3\n" + Tools.repeatString("-", 6));
		System.out.println(rocket1.toStringCurrentSpeed() + "\n"
				+ rocket2.toStringCurrentSpeed());
		System.out.println("\nBoth rockets speeding up 3 times!");
		printStartingEngines();

		// Initialize number of accelerations and start engines
		int accelerationsR1 = 3;
		int accelerationsR2 = accelerationsR1;
		rocket1.StartEngines(accelerationsR1);
		rocket2.StartEngines(accelerationsR2);

		// Print out running engines and speed for each rocket
		printRocketTitle(rocket1.getRocketId(), rocket2.getRocketId(),
				rocket1.numberOfEngines(), rocket2.numberOfEngines());
		printRunningEngines(rocket1, rocket2);

		// Print out current speed once treads are complete
		System.out.println("\n" + rocket1.toStringCurrentSpeed()
				+ "\n" + rocket2.toStringCurrentSpeed());

		// Print out new rockets acceleration to be performed
		System.out.println("\n\nRocket " + rocket1.getRocketId()
				+ " speeding down 5 times!");
		System.out.println("Rocket " + rocket2.getRocketId()
				+ " speeding up 7 times!");
		printStartingEngines();

		// Clone rockets engines so threads can be started again,
		// assign new values to accelerations and start engines
		rocket1.setRocketEngines(rocket1.cloneEngines());
		rocket2.setRocketEngines(rocket2.cloneEngines());
		accelerationsR1 = -5;
		accelerationsR2 = 7;
		rocket1.StartEngines(accelerationsR1);
		rocket2.StartEngines(accelerationsR2);

		// Print out running engines and speed for each rocket
		printRocketTitle(rocket1.getRocketId(), rocket2.getRocketId(),
				rocket1.numberOfEngines(), rocket2.numberOfEngines());
		printRunningEngines(rocket1, rocket2);

		// Print out current speed once treads are complete
		System.out.println("\n" + rocket1.toStringCurrentSpeed()
				+ "\n" + rocket2.toStringCurrentSpeed());

		// Print out new rockets acceleration to be performed
		System.out.println("\nBoth rockets speeding up 15 times!");
		printStartingEngines();

		// Clone rockets engines so threads can be started again,
		// assign new values to accelerations and start engines
		rocket1.setRocketEngines(rocket1.cloneEngines());
		rocket2.setRocketEngines(rocket2.cloneEngines());
		accelerationsR1 = 15;
		accelerationsR2 = accelerationsR1;
		rocket1.StartEngines(accelerationsR1);
		rocket2.StartEngines(accelerationsR2);

		// Print out running engines and speed for each rocket
		printRocketTitle(rocket1.getRocketId(), rocket2.getRocketId(),
				rocket1.numberOfEngines(), rocket2.numberOfEngines());
		printRunningEngines(rocket1, rocket2);

		// Print out current speed once treads are complete
		System.out.println("\n" + rocket1.toStringCurrentSpeed()
				+ "\n" + rocket2.toStringCurrentSpeed());
	}

	// Prints out running engines power and rockets updated
	// speed at every acceleration cycle
	public static void printRunningEngines(Rocket rocket1,
			Rocket rocket2) {
		if ((rocket1.numberOfEngines() > 0)
				&& (rocket2.numberOfEngines() > 0)) {
			int accelerationsR1 = rocket1.getEngineByIndex(0)
					.getAccelerations();
			int accelerationsR2 = rocket2.getEngineByIndex(0)
					.getAccelerations();
			int i = 0;
			while ((i < Math.abs(accelerationsR1) + 1)
					|| (i < Math.abs(accelerationsR2) + 1)) {
				String toPrintString = "";
				if ((rocket1.isReadyToPrint(i))
						&& (i > Math.abs(accelerationsR2))) {
					if (i > 0) {
						rocket1.setCurrentSpeed(
								rocket1.updateSpeed(i));
					}
					toPrintString += rocket1.toStringEnginePower(i);
				} else if ((rocket2.isReadyToPrint(i))
						&& (i > Math.abs(accelerationsR1))) {
					if (i > 0) {
						rocket2.setCurrentSpeed(
								rocket2.updateSpeed(i));
					}
					toPrintString += Tools.repeatString(" ", 30)
							+ rocket2.toStringEnginePower(i);
				} else if ((rocket1.isReadyToPrint(i))
						&& (rocket2.isReadyToPrint(i))) {
					if (i > 0) {
						rocket1.setCurrentSpeed(
								rocket1.updateSpeed(i));
						rocket2.setCurrentSpeed(
								rocket2.updateSpeed(i));
					}
					toPrintString += rocket1.toStringEnginePower(i)
							+ "    " + rocket2.toStringEnginePower(i);
				}
				if (!toPrintString.isEmpty()) {
					System.out.println(toPrintString);
					i++;
//					Tools.myDelay(500);
				}
			}
		}
	}

	// Prints out phase 1 and 2
	public static void printPhase1and2(Rocket rocket1,
			Rocket rocket2) {
		System.out.println("Phase1\n" + Tools.repeatString("-", 6));
		System.out.println(rocket1.toStringPhase1());
		System.out.println(rocket2.toStringPhase1());
		System.out.println("\nPhase2\n" + Tools.repeatString("-", 6));
		System.out.println(rocket1.toStringPhase2());
		System.out.println(rocket2.toStringPhase2());
	}

	// Prints 'starting engines' line
	public static void printStartingEngines() {
		System.out.print("Starting engines");
		for (int i = 0; i < 5; i++) {
//			Tools.myDelay(300);
			System.out.print(".");
		}
		System.out.println("\n");
	}

	// Prints rocket's title line
	public static void printRocketTitle(String rocketId1,
			String rocketId2, int numEnginesRocket1,
			int numEnginesRocket2) {
		System.out.println(Tools.trailingString(rocketId1,
				numEnginesRocket1 * 5 + 15)
				+ Tools.trailingString(rocketId2,
						numEnginesRocket2 * 5 + 11)
				+ "\n"
				+ Tools.repeatString("-", numEnginesRocket1 * 5 + 11)
				+ Tools.repeatString(" ", 4)
				+ Tools.repeatString("-", numEnginesRocket2 * 5 + 11)
				+ Tools.sandwichString("\nengines power", "speed",
						numEnginesRocket1 * 5 + 12)
				+ Tools.repeatString(" ", 4)
				+ Tools.sandwichString("engines power", "speed",
						numEnginesRocket2 * 5 + 11));
	}

}
