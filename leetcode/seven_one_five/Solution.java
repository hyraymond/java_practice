package seven_one_five;
import java.util.*;
class Range implements Comparable<Range>{
    int l;
    int r;
    Range(int lp, int rp){
        l = lp;
        r = rp;
    }
    Range(Range range){
        l = range.l;
        r = range.r;
    }
    @Override
    public int compareTo(Range o){
        if (r == o.r){
            return l - o.l;
        }
        return r - o.r;
    }
}
class RangeModule {
    TreeSet<Range> list;
    public RangeModule() {
        list = new TreeSet<Range>();
    }
    
    public void addRange(int left, int right){
        if (null == list){
            return;
        }
        if (right <= left){
            return;
        }

        Iterator<Range> cursor = list.iterator();
        Range t = new Range(left, right);

        while (cursor.hasNext()) {
            Range cur = cursor.next();

            if (left > cur.r){
                continue;
            }
            if (right < cur.l){
                break;
            }
            left = Math.min(left, cur.l);
            right = Math.max(right, cur.r);
            cursor.remove();
        }

        t.l = left;
        t.r = right;
        list.add(t);
    }
    
    public boolean queryRange(int left, int right) {
        if (null == list){
            return false;
        }
        if (right <= left){
            return false;
        }

        Iterator<Range> cursor = list.iterator();
        while(cursor.hasNext()){
            Range cur = cursor.next();
            if (left >= cur.l && right <= cur.r){
                return true;
            }
        }
        return false;
    }
    
    public void removeRange(int left, int right){
        if (null == list){
            return;
        }
        if (right <= left){
            return;
        }

        Iterator<Range> cursor = list.iterator();
        List<Range> tem_list = new LinkedList<Range>();

        while (cursor.hasNext()) {
            Range cur = cursor.next();

            if (left >= cur.r){
                continue;
            }
            if (right < cur.l){
                break;
            }
            if (left > cur.l){
                tem_list.add(new Range(cur.l, left));
            }
            if (right < cur.r){
                tem_list.add(new Range(right, cur.r));
            }
            cursor.remove();
        }

        for (Range t: tem_list){
            list.add(new Range(t));
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
