package jian_zhi;

/**
 * 机器人运动范围
 */
public class Solution1 {

    public int movingCount(int threshold, int rows, int cols) {

        boolean[][] visited = new boolean[rows][cols];

        return dfs(0, 0, rows, cols, threshold, visited);
    }

    private int dfs(int i, int j, int rows, int cols, int threshold, boolean[][] visited){

        if(i >= rows || j >= cols || getSum(i) + getSum(j) > threshold || visited[i][j] == true)
            return 0;

        visited[i][j] = true;

        return 1 + dfs(i+1, j, rows, cols, threshold, visited) +
                dfs(i, j+1, rows, cols, threshold, visited);
    }


    private int getSum(int num){

        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }

        int b = 1;
        int a = 0;

        return sum;
    }
}