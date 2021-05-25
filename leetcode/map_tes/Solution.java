//题目：map接口的练习
package map_tes;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
public class Solution
{
    public static void main(String[] args)
    {
        Map<Integer, String> tes_map = new HashMap<Integer, String>() {{
            put(1, "red");
            put(2, "white");
            put(3, "pink");
            put(4, "black");
        }};
        System.out.println(tes_map);
        Set<Integer> key_set = tes_map.keySet();
        Collection<String> value_set = tes_map.values();
        System.out.println(key_set);
        System.out.println(value_set);
        System.out.println(tes_map.containsKey(1));
        System.out.println(tes_map.containsValue("red"));
        System.out.println(tes_map.get(3));
        tes_map.remove(1);
        System.out.println(tes_map.containsKey(1));
        tes_map.clear();
        System.out.println(tes_map);
    }
}