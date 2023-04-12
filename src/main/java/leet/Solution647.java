package leet;

import java.util.Arrays;

public class Solution647 {

    public int countSubstrings(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for(int i=0; i<len; i++){
            Arrays.fill(dp[i], false);
        }

        int ans = 0;
        for(int i=0; i<len; i++){
            for(int j=i; j>=0; j--){

                if(s.charAt(i) == s.charAt(j) && (i-j <= 1 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    ans += 1;
                }
            }
        }

        return ans;
    }
}
