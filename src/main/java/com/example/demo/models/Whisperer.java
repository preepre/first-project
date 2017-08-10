package com.example.demo.models;

public class Whisperer {
	
	private String s;
	
	public Whisperer(String msg) {
		s = msg;
	}
	
	public String whisper() {
		return s.toLowerCase();
	}

}
