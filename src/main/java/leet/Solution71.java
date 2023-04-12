package leet;

import java.util.ArrayList;
import java.util.List;

public class Solution71 {

    public String simplifyPath(String path){

        int len = path.length();
        List<String> segments = new ArrayList<>();

        int i=0;
        while(i<len){

            int post = i+1;
            while(post < len && path.charAt(post) != '/')
                post += 1;

            if(post != i+1){

                String tmp = path.substring(i+1, post);
                if(!tmp.equals(".")){

                    if(tmp.equals("..")){
                        if(segments.size() != 0)
                            segments.remove(segments.size()-1);
                    }else{
                        segments.add(tmp);
                    }
                }

            }

            i = post;
        }

        String ans = String.join("/", segments);

        return '/' + ans;
    }
}
