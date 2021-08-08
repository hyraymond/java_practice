package August_7th;

import java.util.*;
class Solution {
    public int minCut(String s) {
        boolean[][] bool=new boolean[s.length()][s.length()];
        for (int i=s.length()-1;i>=0;i--){
            for (int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1>j-1){
                        bool[i][j]=true;
                    }else{
                        bool[i][j]=bool[i+1][j-1];
                    }
                }
            }
        }
        int[] dp=new int[s.length()];
        dp[0]=1;
        for (int i=0;i<s.length();i++){
            dp[i]=Integer.MAX_VALUE;
            for (int j=0;j<=i;j++){
                if(bool[j][i]){
                    dp[i]=Math.min(dp[i],(j-1>=0?dp[j-1]:0)+1);
                }
            }
        }
        return dp[s.length()-1]-1;
    }
}

