package com.siwuxie095.onlineprogramming.swordtooffer.question064;

/**
 * @author Jiajing Li
 * @date 2021-05-20 09:57:34
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[] {2,3,4,2,6,2,5,1};
        System.out.println(solution.maxInWindows(num, 3));
    }

}
