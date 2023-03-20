package jian_zhi;

public class Solution2 {

    private int ans;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int movingCount(int threshold, int rows, int cols) {
        ans = 0;
        boolean vis[][] = new boolean[rows][cols];
        findGrid(vis, 0, 0, rows, cols, threshold);
        return ans;
    }


    private void findGrid(boolean vis[][], int i, int j, int rows, int cols, int threshold){

        if(i < 0 || i >= rows || j < 0 || j >= cols || vis[i][j] != false || getNumberSum(i) + getNumberSum(j) > threshold)
            return;
        vis[i][j] = true;
        ans += 1;
        for(int k=0; k<4; k++) {
            findGrid(vis, i + directions[k][0], j + directions[k][1], rows, cols, threshold);
        }
    }


    private int getNumberSum(int number){

        int res = 0;
        while(number != 0){
            res += number%10;
            number = number/10;
        }

        return res;
    }
}