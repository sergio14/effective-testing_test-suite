package com.effectivetesting.examples;

public class MotorVehicle {
	private int rpm;
	
	public MotorVehicle() {
		rpm = 0;
	}
	
	public int getCurrentRmp() {
		return rpm;
	}
	
	public void startEngine() {
		rpm = 1000;
		System.out.println("Engine started.");
	
	}
}
