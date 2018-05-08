package com.dumsky284;

public class QuickUnionUF {

	private int[] ids;
	
	QuickUnionUF(int N){
		ids = new int[N];
		for(int i=0; i<N; i++)
			ids[i] = i;
	}
	
	private int getRoot(int node) {
		/*int root = 0;
		if(ids[node] == node) root=node;
		else root = getRoot(ids[node]);
		return root;*/
		int i = node;
		while(i != ids[i]) i = ids[i];
		ids[node] = i;					//When the root was found, point the node to the root to flatten the tree
		return i;
	}
	
	public boolean connected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}
	
	public void connect(int p, int q) {
		ids[getRoot(p)] = getRoot(q);
	}
	
	@Override
	public String toString() {
		String arrayPrint = new String();
		for(int i=0; i<ids.length; i++)
			arrayPrint += ids[i]+" ";
		
		return arrayPrint;
	}
	
}
