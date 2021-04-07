package com.siwuxie095.onlineprogramming.swordtooffer.question013;

/**
 * @author Jiajing Li
 * @date 2021-04-07 19:38:12
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int[] res = solution.reOrderArray(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

}
