package com.siwuxie095.onlineprogramming.swordtooffer.question065;

/**
 * JZ65 矩阵中的路径
 *
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的
 * 任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵
 * 中的某一个格子，则该路径不能再进入该格子。
 *
 * 例如
 * a  b  c  e
 * s  f  c  s
 * a  d  e  e
 *
 * 矩阵中包含一条字符串 "bcced" 的路径，但是矩阵中不包含 "abcb" 路径，因为字符串的第一个字符 b
 * 占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 *
 * 示例1
 *
 * 输入
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
 *
 * 返回值
 * true
 *
 *
 * 示例2
 *
 * 输入
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcb"
 *
 * 返回值
 * false
 *
 *
 * 备注:
 * 0 <= matrix.length <= 200
 * 0 <= matrix[i].length <= 200
 *
 * @author Jiajing Li
 * @date 2021-05-20 11:13:20
 */
@SuppressWarnings("all")
public class Solution {

    public boolean hasPath(char[][] matrix, String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == word.charAt(0)) {
                    boolean visit[][] = new boolean[matrix.length][matrix[0].length];
                    if (dfs(matrix, visit, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, boolean[][] visit, int row, int col, String word, int idx) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length
                || visit[row][col] == true) {
            return false;
        }
        if(word.charAt(word.length() - 1) == matrix[row][col] && (idx == word.length() - 1)) {
            return true;
        }
        if (word.charAt(idx) == matrix[row][col]) {
            visit[row][col] = true;
            if(dfs(matrix, visit, row +1, col, word, idx + 1)
                    || dfs(matrix, visit, row, col + 1, word, idx + 1)
                    || dfs(matrix, visit, row, col - 1, word, idx + 1)
                    || dfs(matrix, visit, row - 1, col, word, idx + 1)) {
                return true;
            }
            visit[row][col] = false;
        }
        return false;
    }

}
