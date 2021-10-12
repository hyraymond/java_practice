package two_nine_five;
import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
    }
    
    public void addNum(int num) {
        int l = max.isEmpty()? Integer.MIN_VALUE: max.peek();
        if (num > l){
            min.add(num);
        }
        else{
            max.add(num);
        }

        int diff = min.size() - max.size();
        if (diff == 2){
            max.add(min.poll());
        }
        else if (diff == -1){
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if ((min.size() + max.size())%2 == 0){
            return ((double)min.peek() + (double)max.peek())/2;
        }
        return min.peek();
    }
    public static void main(String[] args){
        MedianFinder k = new MedianFinder();
        k.addNum(1);
        System.out.println(k.findMedian());
        k.addNum(2);
        System.out.println(k.findMedian());
        k.addNum(3);
        System.out.println(k.findMedian());
        k.addNum(4);
        System.out.println(k.findMedian());
        k.addNum(5);
        System.out.println(k.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */