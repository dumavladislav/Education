package com.dumsky284;

public class WeightedUnion {
	
	private int[] ids;
	private int[] sz;	// Array holding the sized of trees with the root i
	
	WeightedUnion(int N){
		ids = new int[N];
		sz = new int[N];
		for(int i=0; i<N; i++)
		{
			ids[i] = i;
			sz[i] = 1;
		}
	}
	
	private int getRoot(int node) {
		/*int root = 0;
		if(ids[node] == node) root=node;
		else root = getRoot(ids[node]);
		return root;*/
		int i = node;
		while(i != ids[i]) i = ids[i];
		ids[node] = i;	//When the root was found, point the node to the root to flatten the tree
		return i;
	}
	
	public boolean connected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}
	
	public void connect(int p, int q) {
		int proot = getRoot(p); 
		int qroot = getRoot(q);
		if(proot == qroot) return;
		if(sz[proot] < sz[qroot])
		{
			ids[proot] = qroot;
			sz[qroot] += sz[proot]; 
		}
		else
		{
			ids[qroot] = proot;
			sz[proot] += sz[qroot];
		}
		
	}
	
	@Override
	public String toString() {
		String arrayPrint = new String();
		for(int i=0; i<ids.length; i++)
			arrayPrint += ids[i]+" ";
		
		return arrayPrint;
	}
}
