package July_11th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Solution1
// class MedianFinder {
//     List<Integer> table;
//     int sig;
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         table = new ArrayList<Integer>();
//         sig = 0;
//     }
    
//     public void addNum(int num) {
//         table.add(num);
//         sig = 0;
//     }
    
//     public double findMedian() {
//     	if (sig == 0)
//     	{
// 	        Collections.sort(table);
// 	        sig = 1;
//     	}
//         int n = table.size();
//         if (n == 0)
//         {
//         	return ((Double)null);
//         }
//         if (n%2 != 0)
//         {
//         	return table.get((n-1)/2);
//         }
//         else
//         {
//         	return (double)((double)table.get((n-1)/2) + (double)table.get(n/2))/2;
//         }
//     }
//     public static void main(String[] args)
//     {
//         new MedianFinder().findMedian();
//     }
// }

// Solution2, beats 17%
// class MedianFinder {
//     List<Integer> table;
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         table = new ArrayList<Integer>();
//     }
    
//     public void addNum(int num) {
//         int i = 0;
//         int start = 0;
//         int end = table.size() - 1;
//         if (end == -1)
//         {
//             table.add(num);
//             return ;
//         }
//         while (start <= end)
//         {
//             int mid = (start + end)/2;
//             int temp = table.get(mid);
//             if (temp >= num)
//             {
//                 end = mid - 1;
//             }
//             else
//             {
//                 start = mid + 1;
//             }
//         }
//         table.add(start, num);
//     }
    
//     public double findMedian() {
//         int n = table.size();
//         if (n == 0)
//         {
//         	return ((Double)null);
//         }
//         if (n%2 != 0)
//         {
//         	return table.get((n-1)/2);
//         }
//         else
//         {
//         	return (double)((double)table.get((n-1)/2) + (double)table.get(n/2))/2;
//         }
//     }
//     public static void main(String[] args)
//     {
//         MedianFinder t = new MedianFinder();
//         t.addNum(-1);
//         System.out.println(t.findMedian());
//         t.addNum(-2);
//         System.out.println(t.findMedian());
//         t.addNum(-3);
//         System.out.println(t.findMedian());
//         t.addNum(-4);
//         System.out.println(t.findMedian());
//         t.addNum(-5);
//         System.out.println(t.findMedian());
//     }
// }

// Solution3, double heap, beats 43%
class MedianFinder {
    int n;
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    /** initialize your data structure here. */
    public MedianFinder() {
        n = 0;
        maxheap = new PriorityQueue<Integer>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }
            
        });
        minheap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (n == 0)
        {
            maxheap.add(num);
        }
        else
        {
            if (num > maxheap.peek())
            {
                minheap.add(num);
            }
            else
            {
                maxheap.add(num);
            }
            int n1 = maxheap.size();
            int n2 = minheap.size();
            if (n1 - n2 == 2)
            {
                int temp = maxheap.peek();
                maxheap.poll();
                minheap.add(temp);
            }
            else if (n1 - n2 == -1)
            {
                int temp = minheap.peek();
                minheap.poll();
                maxheap.add(temp);
            }
        }
        ++n;
    }
    
    public double findMedian() {
        if (n == 0)
        {
        	return ((Double)null);
        }
        if (n%2 != 0)
        {
        	return maxheap.peek();
        }
        else
        {
        	return (double)((double)maxheap.peek() + (double)minheap.peek())/2;
        }
    }
    public static void main(String[] args)
    {
        MedianFinder t = new MedianFinder();
        t.addNum(-1);
        System.out.println(t.findMedian());
        t.addNum(-2);
        System.out.println(t.findMedian());
        t.addNum(-3);
        System.out.println(t.findMedian());
        t.addNum(-4);
        System.out.println(t.findMedian());
        t.addNum(-5);
        System.out.println(t.findMedian());
    }
}
