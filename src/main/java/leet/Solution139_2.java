package leet;

import java.util.List;

public class Solution139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for(int l=1; l<=len; l++){
            for(int j=0; j<l; j++){
                String tmp = s.substring(j, l);
                if(dp[j] && wordDict.contains(tmp)){
                    dp[l] = true;
                    break; // !!!!
                }
            }
        }

        return dp[len];
    }
}
