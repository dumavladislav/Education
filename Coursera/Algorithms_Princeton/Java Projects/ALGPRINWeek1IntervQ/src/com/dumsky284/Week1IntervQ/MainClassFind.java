package com.dumsky284.Week1IntervQ;

public class MainClassFind {
	
	public static void main(String[] args) {
		WeightedUnion wu = new WeightedUnion(10);
		
		wu.union(1, 9);
		wu.union(2, 6);
		wu.union(2, 9);
		System.out.println(wu.find(1));
		
	}
	
}
