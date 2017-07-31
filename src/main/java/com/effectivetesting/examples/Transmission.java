package com.effectivetesting.examples;

public interface Transmission {
	public void setMode(String mode);
	public void gearUp();
	public void gearDown();
	public int showCurrentGear();

}
