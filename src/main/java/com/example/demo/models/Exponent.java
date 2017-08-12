package com.example.demo.models;

public class Exponent {
	
	private int secret1; 
	private double secret2;
	
	public Exponent( int first, double second ) {
		secret1 = first;
		secret2 = second;
		
	}

	public double calculate() {
		
		return Math.pow(secret1, secret2);
		
//		for (int i=0; i<= secret2; i++) {
//			double n = secret1*secret1;
//		}
			
	}

}
