import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private final boolean[][] grid;
    private final WeightedQuickUnionUF wuf;
    private final WeightedQuickUnionUF wufFullcheck;
    private final int fullMatrixSize;
    private int numOfOpenedSites;

    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        if (n <= 0) throw new IllegalArgumentException();
        numOfOpenedSites = 0;
        grid = new boolean[n][n];
        fullMatrixSize = n*n;
        wuf = new WeightedQuickUnionUF(fullMatrixSize+2);
        wufFullcheck = new WeightedQuickUnionUF(fullMatrixSize+1);
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
                grid[i][j] = false;
        }
    }
    
    public void open(int row, int col)    // open site (row, col) if it is not open already
    {
        if (!validRowCol(row, col)) throw new IllegalArgumentException();
        if (!isOpen(row, col)) {
            grid[row-1][col-1] = true;
            numOfOpenedSites += 1;
            int siteIndex = getFlatIndex(row, col);
            if (row > 1) {
                if (isOpen(row-1, col))
                    unionNodes(siteIndex, getFlatIndex(row-1, col));
            }
            if (row < grid.length) {
                if (isOpen(row+1, col))
                    unionNodes(siteIndex, getFlatIndex(row+1, col));
            }
            if (col > 1) {
                if (isOpen(row, col-1))
                    unionNodes(siteIndex, getFlatIndex(row, col-1));
            }
            if (col < grid.length) {
                if (isOpen(row, col+1))
                    unionNodes(siteIndex, getFlatIndex(row, col+1));
            }
            if (row == 1) unionNodes(0, siteIndex);
            if (row == grid.length) unionNodes(fullMatrixSize+1, siteIndex);
        }
    }
    
    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        if (!validRowCol(row, col)) throw new IllegalArgumentException();
        return grid[row-1][col-1];
    }
    
    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        if (!validRowCol(row, col)) throw new IllegalArgumentException();
        if (!isOpen(row, col)) return false;
        return wufFullcheck.connected(0, getFlatIndex(row, col));
    }
    
    public int numberOfOpenSites()       // number of open sites
    {
        return numOfOpenedSites;
    }
    
    public boolean percolates()              // does the system percolate?
    {
        return wuf.connected(0, fullMatrixSize+1);
    }
    
    private int getFlatIndex(int row, int col) {
        if (!validRowCol(row, col)) throw new IllegalArgumentException();
        return (row-1)*grid.length+col-1+1;
    }
    
    private boolean validRowCol(int row, int col) {
        if (row < 1 || row > grid.length || col < 1 || col > grid.length) return false;
        return true;
    }
    
    private void unionNodes(int p, int q) {
        wuf.union(p, q);
        if (p != (fullMatrixSize + 1) && q != (fullMatrixSize + 1)) wufFullcheck.union(p, q);
    }
    
}
