package com.effectivetesting.examples;

public class Car {
	private int rpm;	
	
    public Car() {
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
