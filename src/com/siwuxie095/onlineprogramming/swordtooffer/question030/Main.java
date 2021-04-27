package com.siwuxie095.onlineprogramming.swordtooffer.question030;

/**
 * @author Jiajing Li
 * @date 2021-04-27 17:52:47
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,-2,3,10,-4,7,2,-5};
        System.out.println(solution.FindGreatestSumOfSubArray(arr));
        arr = new int[] {2,8,1,5,9};
        System.out.println(solution.FindGreatestSumOfSubArray(arr));
    }

}
