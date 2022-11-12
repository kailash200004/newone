package com.jci.controller;

 

 
public class Testing {
	 

	public static void main(String[] args) {
		String regno ="05021200020";
		boolean zero = regno.startsWith("0");
		System.out.println("zero = "+zero);
		long reg = Long.parseLong(regno)+1;
		System.out.println("regno = "+reg);
		 
	}

 
}
