package com.client;

public class MyCell {
	private final String strVal;
	private final int numVal;

	public MyCell(String name, int value) {
		this.strVal = name;
		this.numVal = value;
	}

	public String getStrVal() {
		return strVal;
	}

	public int getNumVal() {
		return numVal;
	}
}
