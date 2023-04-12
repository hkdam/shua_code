package leet;

public class Solution10 {

    public boolean isMatch(String s, String p) {

        return matchStr(s, 0, p, 0);
    }

    private boolean matchStr(String s, int sIndex, String p, int pIndex){

        int sLength = s.length();
        int pLength = p.length();

        if(sIndex == sLength && pIndex == pLength)
            return true;

        if(sIndex < sLength && pIndex < pLength && (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex))){

            if(matchStr(s, sIndex+1, p, pIndex+1))
                return true;

            if(pIndex+1 < pLength && p.charAt(pIndex+1) == '*'){
                if(matchStr(s, sIndex+1, p, pIndex))
                    return true;
            }
        }

        if(pIndex+1 < pLength && p.charAt(pIndex+1) == '*'){
            if(matchStr(s, sIndex, p, pIndex+2))
                return true;
        }

        return false;
    }
}
