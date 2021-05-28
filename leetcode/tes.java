import four.*;
import java.util.*;
public class tes {
    int a;
    tes(){
        this.a = 4;
    }
    public static void main (String[] args) {
        int a = 3;
        List<Integer> p = new ArrayList<Integer>();
        p.add(a);
        a = 4;
        for (int k: p)
        {
            System.out.println(k);
        }
    }
}