package leet;

public class Solution6 {
    public String convert(String s, int numRows) {

        int len = s.length();
        if(numRows == 1 || numRows >= len)
            return s;

        StringBuffer[] strRows = new StringBuffer[numRows];
        for(int i=0; i<numRows; i++){
            strRows[i] = new StringBuffer();
        }

        int i=0;
        while(i < len){
            for(int j=0; j<numRows && i < len; j++){
                strRows[j].append(s.charAt(i++));
            }

            for(int j=numRows-2; j>0 && i < len; j--){
                strRows[j].append(s.charAt(i++));
            }
        }

        StringBuffer ans = new StringBuffer(len);
        for(i=0; i<numRows; i++){
            ans.append(strRows[i]);
        }

        return ans.toString();
    }
}
