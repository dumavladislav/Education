package com.dumsky284.Week1IntervQ;

public class UnionFindPathCompression {
	private int[] id;
	
	UnionFindPathCompression(int N){
		id = new int[N];
		for(int i=0; i<N; i++)
			id[i] = i;
	}
	
	private int root(int i) {
		int node = i;
		while(i != id[i]) i = id[i];
		id[node] = i;
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int proot = root(p-1);
		int qroot = root(q-1);
		id[proot] = qroot;
	}
}
