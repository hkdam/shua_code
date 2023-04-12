package leet;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        int[] mp = new int[26];

        if(s.length() < p.length())
            return ans;

        for(int i=0; i<p.length(); i++){
            mp[s.charAt(i) - 'a'] += 1;
            mp[p.charAt(i) - 'a'] -= 1;
        }

        if(isValid(mp))
            ans.add(0);

        int pLen = p.length();
        for(int i=p.length(); i<s.length(); i++){

            mp[s.charAt(i-pLen) - 'a'] -= 1;
            mp[s.charAt(i) - 'a'] += 1;

            if(isValid(mp))
                ans.add(i-pLen+1);
        }

        return ans;
    }


    private boolean isValid(int[] mp){

        for(int i=0; i<26; i++){
            if(mp[i] != 0)
                return false;
        }

        return true;
    }
}
