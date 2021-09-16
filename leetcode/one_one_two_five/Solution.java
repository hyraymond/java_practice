package one_one_two_five;
import java.util.*;
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n  = req_skills.length;
        Map<String, Integer> con = new HashMap<String, Integer>();
        int p = 1;
        for (int i = 0; i < req_skills.length; ++i)
        {
            con.put(req_skills[i], p);
            p = p << 1;
        }

        int len = (int)Math.pow(2, n);
        int[] dp = new int[len];
        int[] preState = new int[len];
        int[] pre = new int[len];
        int[] skills = new int[people.size()];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < people.size(); ++i)
        {
            List<String> skill = people.get(i);
            int temp = 0;
            for (int j = 0; j < skill.size(); ++j)
            {
                temp = temp | (con.get(skill.get(j)));
            }
            skills[i] = temp;
        }

        for (int i = 0; i < skills.length; ++i)
        {
            int pstate = skills[i];
            for (int j = len - 1; j >= 0; --j)
            {
                if (dp[j] == -1)
                {
                    continue;
                }

                int state = j | pstate;
                if (dp[state] == -1 || dp[state] > dp[j] + 1)
                {
                    dp[state] = dp[j] + 1;
                    preState[state] = j;
                    pre[state] = i;
                }
            }
        }

        int l = dp[len - 1];
        int[] result = new int[l];
        int a = pre[len - 1];
        int temp = len - 1;
        for (int i = l - 1; i >= 0; --i)
        {
            result[i] = a;
            temp = preState[temp];
            a = pre[temp];
        }

        return result;
    }
}
