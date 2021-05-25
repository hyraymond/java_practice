//题目：list接口的练习
package list_tes;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args)
    {
        /* 匿名内部类初始化list */
        List<Integer> test_list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        List<Integer> test_list2 = new ArrayList<Integer>() {{
            addAll(test_list);
        }};
        Integer[] pop = {5, 4, 3, 2, 1};
        List<Integer> test_list3 = Arrays.asList(pop);
        System.out.println(test_list.get(3));
        System.out.println(test_list2.get(3));
        System.out.println(test_list3.get(3));
        Integer p = 1;
        System.out.println(test_list.indexOf(p));
        test_list.remove(3);
        System.out.println(test_list.get(3));
        test_list.set(3, p);
        System.out.println(test_list.get(3));
        List<Integer> test_list4 = test_list2.subList(0, 5);
        System.out.println(test_list4.get(3));
        test_list.clear();
        System.out.println(test_list);

        Iterator<Integer> tes_iterator = test_list2.iterator();
        System.out.println(test_list2);
        System.out.println(tes_iterator.next());
        tes_iterator.remove();
        System.out.println(test_list2);
        System.out.println(tes_iterator.next());
        System.out.println(tes_iterator.next());
        System.out.println(tes_iterator.next());
        System.out.println(tes_iterator.next());
        System.out.println(tes_iterator.hasNext());
    }
}