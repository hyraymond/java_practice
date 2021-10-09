package two_three_six;
import java.util.*;
// 236, Alien Dictionary
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> pre = new HashMap<>();
        Map<Character, Set<Character>> edge = new HashMap<>();
        int n = words.length;

        for (int i = 0; i < n; ++i){
            String a = words[i];
            for (int j = 0; j < a.length(); ++j){
                char temp = a.charAt(j);
                if (!pre.containsKey(temp)){
                    pre.put(temp, 0);
                }
            }
        }
        int sym = 0;
        for (int i = 0; i < n - 1; ++i)
        {
            sym = 0;
            int len = Math.min(words[i].length(), words[i+1].length());
            for (int j = 0; j < len; ++j){
                char a = words[i].charAt(j);
                char b = words[i+1].charAt(j);
                if (a != b && (!edge.containsKey(a) || (edge.containsKey(a) && !edge.get(a).contains(b)))){
                    int num1 = pre.getOrDefault(a, 0);
                    pre.put(a, num1);
                    int num2 = pre.getOrDefault(b, 0) + 1;
                    pre.put(b, num2);

                    if (!edge.containsKey(a)){
                        edge.put(a, new HashSet<Character>());
                    }
                    edge.get(a).add(b);
                    sym = 1;
                    break;
                }
                if (a != b){
                    sym = 1;
                    break;
                }
            }
            if (sym == 0 && words[i].length() > words[i+1].length()){
                return "";
            }
        }

        StringBuilder result = new StringBuilder();
        int sig = 0;
        while(!pre.isEmpty()){
            Iterator<Character> lm = pre.keySet().iterator();
            sig = 0;
            while(lm.hasNext()){
                char p = lm.next();
                int temp = pre.get(p);
                if (0 == temp){
                    result.append(p);
                    Set<Character> k = edge.get(p);
                    if (k != null){
                        for (char r: k){
                            if (pre.containsKey(r))
                            {
                                int num = pre.get(r)-1;
                                num = num < 0? 0: num;
                                pre.put(r, num);
                            }
                        }
                    }
                    pre.remove(p);
                    sig = 1;
                    break;
                }
            }
            if (sig == 0){
                return "";
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        String[] words = {"wrt","wrf","er","ett","rftt","te"};
        System.out.println(new Solution().alienOrder(words));
    }
}