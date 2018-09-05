
public class BinarySearch {
    
    private int[] dataArray;
    private int iterations;
    
    BinarySearch(int[] inData){
        iterations = 0;
        dataArray = new int[inData.length];
        for(int i=0; i<inData.length; i++)
            dataArray[i] = inData[i];
    }
    
    public int find(int key) {
        iterations = 0;
        int lo=0, hi=dataArray.length-1;
        while(lo<=hi) {
            iterations++;
            int mid = lo + (hi-lo)/2;
            if (key == dataArray[mid]) return mid;
            else if (key < dataArray[mid]) hi = mid-1;
            else if (key > dataArray[mid]) lo = mid+1;
        }
        
        return -1;
    }
    
    public int getIterations() {
        return iterations;
    }
    
    public static void main(String[] args) {
        
        int[] data = {1,5,24,32,33,45,66,71,82};
        BinarySearch bs = new BinarySearch(data);
        
        System.out.println(bs.find(71));
        System.out.println(bs.getIterations());
    }
    
}
