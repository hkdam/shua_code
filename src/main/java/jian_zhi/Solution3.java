package jian_zhi;

public class Solution3 {

    public boolean hasPath(char[][] matrix, String word){

        if(matrix == null || word == null)
            return false;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(dfs(matrix, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }


    private boolean dfs(char[][] matrix, int i, int j, String word, int index){

        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != word.charAt(index))
            return false;

        if(index == word.length()-1)
            return true;

        char tmpChar = matrix[i][j];
        matrix[i][j] = '.';

        if(dfs(matrix, i+1, j, word, index+1) ||
                dfs(matrix, i-1, j, word, index+1) ||
                dfs(matrix, i, j+1, word, index+1) ||
                dfs(matrix, i, j-1, word, index+1))
            return true;

        matrix[i][j] = tmpChar;

        return false;
    }

}
