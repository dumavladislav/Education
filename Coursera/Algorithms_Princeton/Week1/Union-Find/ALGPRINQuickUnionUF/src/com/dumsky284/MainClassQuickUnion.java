package com.dumsky284;

public class MainClassQuickUnion {
	
	public static void main(String[] args) {
		
		QuickUnionUF qu = new QuickUnionUF(10);
		
		System.out.println(qu);
		qu.connect(1, 8);
		System.out.println(qu);
		System.out.println(qu.connected(1, 8));
		System.out.println(qu.connected(1, 9));
		qu.connect(1, 9);
		System.out.println(qu.connected(1, 9));
		System.out.println(qu);
		
		
		WeightedUnion wu = new WeightedUnion(10);
		System.out.println(wu);
		wu.connect(1, 8);
		System.out.println(wu);
		System.out.println(wu.connected(1, 8));
		System.out.println(wu.connected(1, 9));
		wu.connect(1, 9);
		System.out.println(wu.connected(1, 9));
		System.out.println(wu);
	}
	
}
