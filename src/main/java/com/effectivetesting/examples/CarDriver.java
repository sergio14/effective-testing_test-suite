package com.effectivetesting.examples;

public class CarDriver {
	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println(myCar.type);
		
		if(myCar.isDiesel == true) {
			System.out.println("Diesel engine. Use fuel Euro 4.");
		} else {
			System.out.println("Gasoline engine.");
		}
		
		switch (myCar.type) {
	  	case "Sedan":
	  		System.out.println("Doors: 4");
	  		break;
	  	case "Hatchback":
	  		System.out.println("Doors: 3");
	  		break;
	  	case "other":
	  		System.out.println("not determined");
	  }

	}
}
