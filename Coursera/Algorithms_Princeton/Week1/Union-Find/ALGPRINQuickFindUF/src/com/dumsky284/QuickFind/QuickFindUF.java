package com.dumsky284.QuickFind;

public class QuickFindUF {

	private int[] ids;
	
	QuickFindUF(int N){
		
		ids = new int[N];
		
		for(int i=0; i<N; i++)
			ids[i] = i;
		
	}
	
	public boolean connected(int p, int q) {
		return ids[q-1] == ids[p-1];
	}
	
	public void connect(int p, int q) {
		int idp = ids[p-1];
		int idq = ids[q-1];
		for(int i=0; i<ids.length; i++)
		{
			if(ids[i] == idp) ids[i] = idq;
		}
	}
	
	@Override
	public String toString() {
		String arrayString = new String();
		for(int i=0; i<ids.length; i++)
			arrayString += ids[i]+" "; 
		
		return arrayString;
	}
	
}
