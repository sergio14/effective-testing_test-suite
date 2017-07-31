package com.effectivetesting.examples;

public class CarDriver {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.startEngine();
		System.out.println("Current rpms: " + myCar.getCurrentRmp());
		
		myCar.goForward();
		myCar.accelerate(2300);
	}
}
