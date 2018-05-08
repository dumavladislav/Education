package com.dumsky284.Week1IntervQ;

public class WeightedUnion {

	private int[] id;
	private int[] sz;
	private int[] maxElement;
	
	WeightedUnion(int N){
		id = new int[N];
		sz = new int[N];
		maxElement = new int[N];
		for(int i=0; i<N; i++)
		{
			id[i] = i;
			sz[i] = 1;
			maxElement[i] = i;
		}
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
	
	public boolean union(int p, int q) {
		boolean fullTree = false;
		int proot = root(p-1);
		int qroot = root(q-1);
		if(sz[proot]<sz[qroot]) {
			id[proot] = qroot;
			sz[qroot] += sz[proot];
			if(maxElement[qroot]<maxElement[proot])	maxElement[qroot] = maxElement[proot];
			if(sz[qroot] == id.length) fullTree = true;
		}
		else
		{
			id[qroot] = proot;
			sz[proot] += sz[qroot];
			if(maxElement[proot]<maxElement[qroot])	maxElement[proot] = maxElement[qroot];
			if(sz[proot] == id.length) fullTree = true;
		}
		System.out.println("Sizes of p and q: " + sz[proot] + " " + sz[qroot]);
		return fullTree;
	}
	
	public int find(int node) {
		return maxElement[root(node)];
	}
	

	
}
