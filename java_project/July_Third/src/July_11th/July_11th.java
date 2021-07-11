package July_11th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class MedianFinder {
    List<Integer> table;
    int sig;
    /** initialize your data structure here. */
    public MedianFinder() {
        table = new ArrayList<Integer>();
        sig = 0;
    }
    
    public void addNum(int num) {
        table.add(num);
        sig = 0;
    }
    
    public double findMedian() {
    	if (sig == 0)
    	{
	        Collections.sort(table);
	        sig = 1;
    	}
        int n = table.size();
        if (n == 0)
        {
        	return (Double) null;
        }
        if (n%2 != 0)
        {
        	return table.get((n-1)/2);
        }
        else
        {
        	return (double)((double)table.get((n-1)/2) + (double)table.get(n/2))/2;
        }
    }
    public static void main(String[] args)
    {
        new MedianFinder().findMedian();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
