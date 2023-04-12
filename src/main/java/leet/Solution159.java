package leet;

import java.util.HashMap;

public class Solution159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int len = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        int maxLen = 0;

        int left=0, right=0;
        for(; right<len; right++){

            char rightCh = s.charAt(right);
            if(mp.containsKey(rightCh))
                mp.put(rightCh, mp.get(rightCh)+1);
            else
                mp.put(s.charAt(right), 1);

            while(mp.size() > 2){
                char tmp = s.charAt(left);
                int tmpCnt = mp.get(tmp);
                if(tmpCnt > 1){
                    mp.put(tmp, tmpCnt-1);
                }else{
                    mp.remove(tmp);
                }

                left += 1;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
