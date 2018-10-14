
public class TestingClass {
	
    static Percolation  prcl;
    
	public static void main(String[] args)   // test client (optional)
	{
		prcl = new Percolation(3);
//		printPoint(3,1);
		prcl.open(1, 3);
//		printPoint(3,1);
		prcl.open(2, 3);
//		printPoint(3,1);
		prcl.open(3, 3);
//		printPoint(3,1);
		prcl.open(3, 1);
		printPoint(3,1);
/*		System.out.println(prcl.percolates());
		System.out.println(prcl.isFull(1, 1));
		System.out.println(prcl.isOpen(1, 1));
		prcl.open(1, 1);
		System.out.println(prcl.percolates());
		System.out.println(prcl.isFull(1, 1));
		System.out.println(prcl.isOpen(1, 1));*/
		/*prcl.open(1, 2);
		System.out.println(prcl.percolates());
		prcl.open(2, 1);
		System.out.println(prcl.percolates());
		System.out.println(prcl.isFull(2, 1));
		prcl.open(2, 2);
		System.out.println(prcl.percolates());
		System.out.println(prcl.isFull(2, 2));
		
		prcl.open(3, 2);
		System.out.println(prcl.percolates());*/
	}
	
	public static void printPoint(int row, int col) {
	    System.out.println("Percolates: " + prcl.percolates());
        System.out.println("(" + row + "," + col + "): " + prcl.isFull(row, col));
        System.out.println("(" + row + "," + col + "): " + prcl.isOpen(row, col));
	}
}
