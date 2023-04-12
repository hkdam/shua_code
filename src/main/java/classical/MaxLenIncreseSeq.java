package classical;

public class MaxLenIncreseSeq {

    public void getSeq(int[] nums){

        int len = nums.length;
        int[] dp = new int[len];

        int ans = 1;
        for(int i=0; i<len; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(nums[i] >= nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println("ans: " + ans);
    }
}
