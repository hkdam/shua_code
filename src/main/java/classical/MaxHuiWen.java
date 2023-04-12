package classical;

import java.util.Arrays;

public class MaxHuiWen {

    public String getMaxHuiWen(String str){

        int len = str.length();
        int[][] dp = new int[len][len];
        int ans = 1;
        int ansStIndex = 0;
        for(int i=0; i<len; i++){
            Arrays.fill(dp[i], 0);
            dp[i][i] = 1;
        }

        for(int l=2; l<=len; l++){
            for(int i=0; i+l-1<len; i++){
                // 右端坐标
                int j=i+l-1;
                if(str.charAt(i) == str.charAt(j) && (j-i == 1 || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    ans = l;
                    ansStIndex = i;
                }
            }
        }

        return str.substring(ansStIndex, ansStIndex+ans);
    }
}
