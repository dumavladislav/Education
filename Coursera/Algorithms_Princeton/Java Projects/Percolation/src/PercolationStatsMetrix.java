import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStatsMetrix {
    
    private static final double KOEFF = 1.96;
    
    private final int n;
    private final int trials;
    private final double[] percThrshld;
    
     
    private double mean;
    private double stddev;
    /*
    private double confidenceLo;
    private double confidenceHi;
    */
    
    public PercolationStatsMetrix(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        Stopwatch sw = new Stopwatch();
        this.n = n;
        this.trials = trials;
        mean = 0;
        stddev = 0;
        percThrshld = new double[trials];
        startTrials();
        System.out.println(sw.elapsedTime());
    }
    
    public double mean()                          // sample mean of percolation threshold
    {
        if (mean == 0) mean = StdStats.mean(percThrshld);
        return mean;
    }
    
    public double stddev()                        // sample standard deviation of percolation threshold
    {
        if (stddev == 0) stddev = StdStats.stddev(percThrshld);
        return stddev;
    }
    
    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return mean()-(KOEFF*stddev()/Math.sqrt(trials));
    }
    
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return mean()+(KOEFF*stddev()/Math.sqrt(trials));
    }
    
    public static void main(String[] args)        // test client (described below)
    {
        PercolationStatsMetrix stats = new PercolationStatsMetrix(400, 30);
        
        // stats.calculateStats();
        
        System.out.printf("%-25s", "mean");
        System.out.println("= "+ stats.mean());
        System.out.printf("%-25s", "stddev");
        System.out.println("= "+ stats.stddev());
        System.out.printf("%-25s", "95% confidence interval");
        System.out.println("= "+"[" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
    
    private void startTrials() {
        for (int i = 0; i < trials; i++) {
            PercolationQF prcl = new PercolationQF(n);
            while (!prcl.percolates()) {
                int randRow = StdRandom.uniform(n)+1;
                int randCol = StdRandom.uniform(n)+1;
                prcl.open(randRow, randCol);
            }
            percThrshld[i] = (double) prcl.numberOfOpenSites()/(n*n);
        }
    }
    
    /*
    private void calculateStats() {
        mean = mean();
        stddev = stddev();
        confidenceLo = mean-(KOEFF*stddev/Math.sqrt(trials));
        confidenceHi = mean+(KOEFF*stddev/Math.sqrt(trials));
    }
    */
}
