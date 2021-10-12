package one_four_zero;
import java.util.*;
class Solution {
    private void getResult(String s, List<String> result, List<String> temp, List<Integer>[] r, int index, int rindex)
    {
        if (index != s.length()) temp.add(s.substring(index, rindex));

        if (index == 0)
        {
            StringBuilder bf = new StringBuilder();
            bf.append(temp.get(temp.size()-1));
            for (int i = temp.size() - 2; i >= 0; --i)
            {
                bf.append(" ");
                bf.append(temp.get(i));
            }
            result.add(bf.toString());
            temp.remove(temp.size() - 1);
            return;
        }

        List<Integer> q = r[index];
        for (int i = 0; i < q.size(); ++i)
        {
            int next_index = q.get(i);
            getResult(s, result, temp, r, next_index, index);
        }
        if (index != s.length()) temp.remove(temp.size() - 1);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> con = new HashSet<String>();
        for (String p: wordDict)
        {
            con.add(new String(p));
        }

        int n = s.length();
        List<Integer>[] r = new ArrayList[n+1];
        r[0] = new ArrayList<Integer>() {{
            add(-1);
        }};

        for (int i = 1; i <= s.length(); ++i)
        {
            r[i] = new ArrayList<Integer>();
            for (int j = 0; j < i; ++j)
            {
                String temp = s.substring(j, i);
                if (con.contains(temp) && !r[j].isEmpty())
                {
                    r[i].add(j);
                }
            }
        }

        List<String> temp = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        getResult(s, result, temp, r, n, n);
        return result;
    }
    public static void main(String[] args)
    {
        String s = "catsanddog"; 
        String[] wordDict_ = {"cat","cats","and","sand","dog"};
        List<String> wordDict = new ArrayList<String>() {{
            for (String p: wordDict_)
            {
                add(p);
            }
        }};
        List<String> ls = new Solution().wordBreak(s, wordDict);
        for(String p : ls){
            System.out.println(p);
        }
    }
}