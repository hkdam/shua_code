package leet;

public class Solution161 {

    public boolean isOneEditDistance(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();
        if(sLen > tLen)
            return isOneEditDistance(t, s);

        if(tLen - sLen > 1)
            return false;

        for(int i=0; i<sLen; i++){

            if(s.charAt(i) != t.charAt(i)){

                if(sLen == tLen){
                    return s.substring(i+1, sLen).equals(t.substring(i+1, tLen));
                }else{
                    return s.substring(i, sLen).equals(t.substring(i+1, tLen));
                }
            }
        }

        return sLen != tLen;
    }
}
