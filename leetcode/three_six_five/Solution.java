package three_six_five;

import java.util.*;
class Solution {
    private long hash(int a, int b)
    {
        return (long)a * 10000007 + (long)b;
        // 因为hash冲突的缘故，用long才能通过所有用例！
    }
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int a = Math.max(jug1Capacity, jug2Capacity);
        int b = Math.min(jug1Capacity, jug2Capacity);

        int ta = 0;
        int tb = 0;
        Set<Long> visited = new HashSet<Long>();
        Queue<int[]> con = new LinkedList<int[]>();
        con.offer(new int[] {ta, tb});
        visited.add(hash(ta, tb));
        while (!con.isEmpty())
        {
            int[] temp = con.peek();
            con.poll();
            ta = temp[0];
            tb = temp[1];
            if (ta + tb == targetCapacity || ta == targetCapacity || tb == targetCapacity)
            {
                return true;
            }

            int nta = a;
            int ntb = tb;
            if (visited.contains(hash(nta, ntb)) == false) 
            {
                con.offer(new int[] {nta, ntb});
                visited.add(hash(nta, ntb));
            }

            nta = ta;
            ntb = b;
            if (visited.contains(hash(nta, ntb)) == false) 
            {
                con.offer(new int[] {nta, ntb});
                visited.add(hash(nta, ntb));
            }

            nta = ta;
            ntb = 0;
            if (visited.contains(hash(nta, ntb)) == false) 
            {
                con.offer(new int[] {nta, ntb});
                visited.add(hash(nta, ntb));
            }


            nta = 0;
            ntb = tb;
            if (visited.contains(hash(nta, ntb)) == false) 
            {
                con.offer(new int[] {nta, ntb});
                visited.add(hash(nta, ntb));
            }


            nta = ta - (b - tb) >= 0? ta - (b - tb): 0;
            ntb = ta + tb > b ? b: ta + tb;
            if (visited.contains(hash(nta, ntb)) == false) 
            {
                con.offer(new int[] {nta, ntb});
                visited.add(hash(nta, ntb));
            }

            nta = ta + tb > a ? a: ta + tb;
            ntb = tb - (a - ta) >= 0? tb - (a - ta): 0;
            if (visited.contains(hash(nta, ntb)) == false) 
            {
                con.offer(new int[] {nta, ntb});
                visited.add(hash(nta, ntb));
            }
        }
        return false;
    }
}