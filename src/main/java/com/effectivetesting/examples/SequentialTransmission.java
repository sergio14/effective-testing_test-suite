package com.effectivetesting.examples;

public class SequentialTransmission  implements Transmission {
	
	private int currentGear ;
	
	private String mode;

	private int maxGear = 6;
	
	public SequentialTransmission() {
		currentGear = 0;
	    mode = "NEUTRAL";
		}
	
	
	public void setMode(String mode) {
		this.mode = mode;
		this.gearUp();
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
