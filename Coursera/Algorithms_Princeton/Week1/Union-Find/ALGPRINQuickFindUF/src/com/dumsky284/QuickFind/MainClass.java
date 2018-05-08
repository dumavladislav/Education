package com.dumsky284.QuickFind;

public class MainClass {
	
	public static void main(String[] args) {
		QuickFindUF qf = new QuickFindUF(10);
		
		System.out.println(qf);
		qf.connect(1, 8);
		System.out.println(qf);
		System.out.println(qf.connected(1, 8));
		System.out.println(qf.connected(1, 9));
		qf.connect(1, 9);
		System.out.println(qf);
		
	}
	
}
