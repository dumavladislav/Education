package com.dumsky284.Week1IntervQ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainClass {

	private static final String FILENAME = "logFile.txt";
	private static final int N = 5;
	
	public static void main(String[] args) {
		
		WeightedUnion wu = new WeightedUnion(N);
		
		try {
			String path = new File(".").getCanonicalPath();
			FileReader fr = new FileReader(path+"/"+FILENAME);
			BufferedReader br = new BufferedReader(fr);
			
			String currLine;
			
			while((currLine = br.readLine()) != null) {
				System.out.println(currLine);
				String[] parts = currLine.split(" ");
				//wu.union(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
				if(wu.union(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]))) {
					System.out.println("ALL CONNECTED AT: " + parts[0]);
					return;
				}
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
