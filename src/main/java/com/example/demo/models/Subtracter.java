package com.example.demo.models;

public class Subtracter {
	
	private int secret1; 
	private double secret2;
	
	public Subtracter( int first, double second ) {
		secret1 = first;
		secret2 = second;
		
	}

	public double calculate() {
		return secret1 - secret2;
	}
		
	

}
