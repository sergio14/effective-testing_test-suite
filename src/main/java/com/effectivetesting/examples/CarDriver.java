package com.effectivetesting.examples;

public class CarDriver {
	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println("New car created.");
		myCar.tireSensor.pressure = 29.3f;
		
		for(int i = 0; i < myCar.wheels; i++) {
			if(myCar.tireSensor.pressure > 27.0f) {
				System.out.println("Tire pressure level: normal");
			}
		}

	}
}
