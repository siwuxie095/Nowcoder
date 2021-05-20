package com.siwuxie095.onlineprogramming.swordtooffer.question066;

/**
 * JZ66 机器人的运动范围
 *
 * 题目描述
 * 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1]。一个机器人从坐标 0,0
 * 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和
 * 大于 threshold 的格子。例如，当 threshold 为 18 时，机器人能够进入方格 [35,37]，因为 3+5+3+7
 * = 18。但是，它不能进入方格 [35,38]，因为 3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 范围:
 * 1 <= rows, cols <= 100
 * 0 <= threshold <= 20
 *
 *
 * 示例1
 *
 * 输入
 * 1,2,3
 *
 * 返回值
 * 3
 *
 *
 * 示例2
 *
 * 输入
 * 0,1,3
 *
 * 返回值
 * 1
 *
 *
 * 示例3
 *
 * 输入
 * 10,1,100
 *
 * 返回值
 * 29
 * 说明
 * [0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7],[0,8],[0,9],[0,10],[0,11],[0,12],
 * [0,13],[0,14],[0,15],[0,16],[0,17],[0,18],[0,19],[0,20],[0,21],[0,22],[0,23],[0,24],
 * [0,25],[0,26],[0,27],[0,28] 这 29 种，后面的 [0,29],[0,30] 以及 [0,31] 等等是无法到达的
 *
 *
 * 示例4
 *
 * 输入
 * 5,10,10
 *
 * 返回值
 * 21
 *
 * @author Jiajing Li
 * @date 2021-05-20 17:46:31
 */
@SuppressWarnings("all")
public class Solution {

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold,int rows,int cols,
                                int row,int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col]
                || cal(row) + cal(col) > threshold)
            return 0;
        visited[row][col] = true;
        return 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                + movingCountCore(threshold, rows, cols, row, col + 1, visited);
    }

    private int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
