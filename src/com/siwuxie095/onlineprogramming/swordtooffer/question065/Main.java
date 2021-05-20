package com.siwuxie095.onlineprogramming.swordtooffer.question065;

/**
 * @author Jiajing Li
 * @date 2021-05-20 11:13:30
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][] {{'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}};
        System.out.println(solution.hasPath(matrix, "abcced"));
        System.out.println(solution.hasPath(matrix, "abcb"));
    }

}
