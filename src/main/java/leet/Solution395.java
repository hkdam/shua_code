package leet;

public class Solution395 {

    int longestSubstring(String s, int k) {

        return cntLength(s, 0, s.length()-1, k);
    }


    private int cntLength(String s, int left, int right, int k){

        int[] map = new int[26];
        for(int i=left; i<=right; i++){
            int index = s.charAt(i) - 'a';
            map[index] += 1;
        }

        int st = left, ed = right;
        // 找到第一个符合的
        while(st <= ed && map[s.charAt(st) - 'a'] < k)
            st += 1;

        while(st <= ed && map[s.charAt(ed) - 'a'] < k)
            ed -= 1;

        if(ed - st + 1 < k)
            return 0;

        // 找到第一个不符合的
        int pivot = st;
        while(pivot <= ed && map[s.charAt(pivot) - 'a'] >= k)
            pivot += 1;

        if(pivot >= ed)
            return ed - st + 1;

        return Math.max(cntLength(s, st, pivot-1, k), cntLength(s, pivot+1, ed, k));
    }
}
