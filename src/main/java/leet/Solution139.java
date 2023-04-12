package leet;

import java.util.List;

public class Solution139 {

    boolean[][] flag;
    boolean ans;

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        flag = new boolean[len][len];

        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                String tmp = s.substring(i, j+1);
                if(wordDict.contains(tmp)){
                    flag[i][j] = true;
                }
            }
        }

        ans = false;
        dfs(s, 0);

        return ans;
    }


    private void dfs(String s, int st){

        if(st >= s.length()){
            ans = true;
            return;
        }


        for(int i=st; i<s.length(); i++){
            if(!ans && flag[st][i]){
                dfs(s, i+1);
            }
        }
    }
}
