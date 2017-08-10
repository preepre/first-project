package com.example.demo.models;

public class Yeller {
	
	private String input;
	
	public Yeller(String s) {
		input = s;
	}
	
	public String yell() {
		return input.toUpperCase();
	}

}
