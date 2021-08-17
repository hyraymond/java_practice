package four_nine;

import java.util.*;

// use prime number represents alpha letters, use times as their hash value;
class Solution {
    int c = (int)Math.pow(10, 7) + 7;
    public long get_hash(String str, Map<Character, Integer> hash_check)
    {
        long result = 1;
        for (int i = 0; i < str.length(); ++i)
        {
            result = (result * hash_check.get(str.charAt(i))) % c;
        }
        return result;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        long[] hash_val = new long[n];
        Integer[] num = new Integer[n];
        Map<Character, Integer> hash_check = new HashMap<Character, Integer>() {{
            put('a', 2);
            put('b', 3);
            put('c', 5);
            put('d', 6);
            put('e', 11);
            put('f', 13);
            put('g', 17);
            put('h', 19);
            put('i', 23);
            put('j', 29);
            put('k', 31);
            put('l', 37);
            put('m', 41);
            put('n', 43);
            put('o', 47);
            put('p', 53);
            put('q', 59);
            put('r', 61);
            put('s', 67);
            put('t', 71);
            put('u', 73);
            put('v', 79);
            put('w', 83);
            put('x', 89);
            put('y', 97);
            put('z', 101);
        }};
        for (int i = 0; i < n; ++i)
        {
            hash_val[i] = get_hash(strs[i], hash_check);
            num[i] = i;
        }

        Arrays.sort(num, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return (int)(hash_val[o1.intValue()] - hash_val[o2.intValue()]);
            }
        });
        long key = hash_val[num[0].intValue()];
        temp.add(strs[num[0].intValue()]);
        for(int i = 1; i < n; ++i)
        {
            int index = num[i].intValue();
            long temp_hash = hash_val[index];
            if (key != temp_hash)
            {
                result.add(temp);
                temp = new ArrayList<String>();
                key = temp_hash;
            }
            temp.add(strs[index]);
        }
        result.add(temp);
        return result;
    }
    public static void main(String[] args)
    {
        String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println(new Solution().groupAnagrams(strs));
        char p = 'a';
        System.out.println((char)Math.pow(2, 16));
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);
    }
}