package com.siwuxie095.onlineprogramming.swordtooffer.question051;

/**
 * @author Jiajing Li
 * @date 2021-05-14 15:20:52
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,2,3,4,5};
        arr = solution.multiply(arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

}
