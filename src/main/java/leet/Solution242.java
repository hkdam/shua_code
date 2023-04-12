package leet;

import java.util.HashMap;
import java.util.Map;

public class Solution242 {

    public boolean isAnagram(String s, String t) {

        int[] map = new int[26];
        for(char ch : s.toCharArray()){
            map[ch - 'a'] += 1;
        }

        for(char ch : t.toCharArray()){
            map[ch - 'a'] -= 1;
        }

        for(int i=0; i<26; i++){
            if(map[i] != 0)
                return false;
        }

        return true;
    }
}
