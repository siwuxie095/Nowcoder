package com.siwuxie095.onlineprogramming.swordtooffer.question037;

/**
 * @author Jiajing Li
 * @date 2021-05-08 14:07:47
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,2,3,3,3,3,4,5};
        System.out.println(solution.GetNumberOfK(arr, 3));
        arr = new int[] {3,3,3,3,3};
        System.out.println(solution.GetNumberOfK(arr, 3));
        arr = new int[] {1,1,1,1,1};
        System.out.println(solution.GetNumberOfK(arr, 3));
        arr = new int[] {5,5,5,5,5};
        System.out.println(solution.GetNumberOfK(arr, 3));
    }

}
