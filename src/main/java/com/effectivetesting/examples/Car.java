package com.effectivetesting.examples;

public class Car extends MotorVehicle {
	private Transmission transmission;
	private String message = "Current Gear: ";
	
	public Car() {
		transmission = new AutomaticTransmission();
	}
	public String getType() {
		return "sedan";
	}
    
	public void goForward() {
		transmission.setMode("DRIVE");
		System.out.println("Going forward. " + message + transmission.showCurrentGear());
	}
	
	public void accelerate(int rpm) {
		transmission.gearUp();
		System.out.println("Accelerating: " + rpm + " rpms. " + message + transmission.showCurrentGear());
	}
}
