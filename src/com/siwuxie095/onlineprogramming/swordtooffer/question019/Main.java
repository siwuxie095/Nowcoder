package com.siwuxie095.onlineprogramming.swordtooffer.question019;

import java.util.ArrayList;

/**
 * @author Jiajing Li
 * @date 2021-04-12 10:07:59
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] matrix = new int[][] {{1, 2}, {3, 4}};
        ArrayList<Integer> res = solution.printMatrix(matrix);
        System.out.println(res);
        matrix = new int[][] {{1, 2}};
        res = solution.printMatrix(matrix);
        System.out.println(res);
    }

}
