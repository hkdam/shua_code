package classical;

public class minDistance {

    public int editDistance(String a, String b){

        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen+1][bLen+1];

        for(int i=0; i<=aLen; i++)
            dp[i][0] = i;

        for(int j=0; j<=bLen; j++)
            dp[0][j] = j;

        for(int i=1; i<=aLen; i++){
            for(int j=1; j<=bLen; j++){

                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }


        return dp[aLen][bLen];
    }
}
