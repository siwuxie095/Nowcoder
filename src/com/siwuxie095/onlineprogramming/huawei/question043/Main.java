package com.siwuxie095.onlineprogramming.huawei.question043;

import java.util.Scanner;
import java.util.Stack;

/**
 * 迷宫问题
 *
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * int maze[5][5] = {
 *         0, 1, 0, 0, 0,
 *         0, 1, 0, 1, 0,
 *         0, 0, 0, 0, 0,
 *         0, 1, 1, 1, 0,
 *         0, 0, 0, 1, 0,
 * };
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，
 * 不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],
 * 既第一空格是可以走的路。
 *
 * Input
 * 一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，
 * 即迷宫只有一条通道。
 *
 * Output
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 * Sample Input
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 *
 * Sample Output
 * (0, 0)
 * (1, 0)
 * (2, 0)
 * (2, 1)
 * (2, 2)
 * (2, 3)
 * (2, 4)
 * (3, 4)
 * (4, 4)
 *
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，
 * 其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有
 * 多解的情况，即迷宫只有一条通道。
 *
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 *
 * 示例1
 *
 * 输入
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 *
 * 输出
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 *
 * PS：本题保证了迷宫可以有多条路径，但是只有一条最短路径。
 *
 * @author Jiajing Li
 * @date 2020-03-16 09:06:54
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] maze = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            // flag - has reached the end or not.
            boolean[] flag = new boolean[] {false};
            // shortest path.
            Stack<Point> shortestPath = new Stack<>();
            mazeTrace(maze, 0, 0, N, M, flag, shortestPath);
            Stack<Point> reversePath = new Stack<>();
            while (!shortestPath.isEmpty()) {
                reversePath.push(shortestPath.pop());
            }
            while (!reversePath.isEmpty()) {
                reversePath.pop().printPoint();
            }
        }
    }

    private static void mazeTrace(int[][] maze, int row, int col, int N, int M, boolean[] flag, Stack<Point> shortestPath) {
        if (flag[0]) {
            return;
        }

        maze[row][col] = 1;
        shortestPath.push(new Point(row, col));

        if (row == N - 1 && col == M - 1) {
            flag[0] = true;
            return;
        }
        // 1. priority to go down.
        if (row + 1 < N && maze[row + 1][col] == 0) {
            mazeTrace(maze, row + 1, col, N, M, flag, shortestPath);
        }
        // 2. priority to go right.
        if (col + 1 < M && maze[row][col + 1] == 0) {
            mazeTrace(maze, row, col + 1, N, M, flag, shortestPath);
        }
        // 3. then try to go up.
        if (row - 1 >= 0 && maze[row - 1][col] == 0) {
            mazeTrace(maze, row - 1, col, N, M, flag, shortestPath);
        }
        // 4. then try to go left.
        if (col - 1 >= 0 && maze[row][col - 1] == 0) {
            mazeTrace(maze, row, col - 1, N, M, flag, shortestPath);
        }
        if (flag[0]) {
            return;
        }
        maze[row][col] = 0;
        shortestPath.pop();
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void printPoint() {
            System.out.println("(" + x + "," + y + ")");
        }
    }

}
