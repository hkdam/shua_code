package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution43 {

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1+len2];
        Arrays.fill(ans, 0);

        for(int i=len1-1; i>=0; i--){
            int x = num1.charAt(i) - '0';
            for(int j=len2-1; j>=0; j--){
                int y = num2.charAt(j) - '0';

                ans[i+j+1] += x*y;
            }
        }

        for(int i=len1+len2-1; i>=1; i--){
            ans[i-1] += ans[i]/10;
            ans[i] = ans[i]%10;
        }

        int stIndex = ans[0] == 0 ? 1:0;
        StringBuilder ansStr = new StringBuilder();
        while(stIndex < len1 + len2){
            ansStr.append(ans[stIndex++]);
        }

        return ansStr.toString();
    }
}
