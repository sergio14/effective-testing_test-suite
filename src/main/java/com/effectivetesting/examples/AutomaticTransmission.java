package com.effectivetesting.examples;

public class AutomaticTransmission implements Transmission {
	private int currentGear;
	private int maxGear = 6;
	
	public AutomaticTransmission() {
		currentGear = 0;
	}
	
	public void gearUp() {
		if(currentGear < maxGear) {
			currentGear = currentGear + 1;
		}
	}

	public void gearDown() {
		if(currentGear >= 1)
		currentGear = currentGear - 1;
	}

	public int showCurrentGear() {
		return currentGear;
	}
}
