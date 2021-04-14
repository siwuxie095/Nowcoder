package com.siwuxie095.onlineprogramming.swordtooffer.question023;

/**
 * @author Jiajing Li
 * @date 2021-04-14 10:34:54
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {4,8,6,12,16,14,10};
        System.out.println(solution.VerifySquenceOfBST(arr));
        arr = new int[] {7,4,6,5};
        System.out.println(solution.VerifySquenceOfBST(arr));
        arr = new int[] {4,6,7,5};
        System.out.println(solution.VerifySquenceOfBST(arr));
    }

}
