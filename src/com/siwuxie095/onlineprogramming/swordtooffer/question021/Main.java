package com.siwuxie095.onlineprogramming.swordtooffer.question021;

/**
 * @author Jiajing Li
 * @date 2021-04-13 15:23:13
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        int[] pushA = new int[] {1,2,3,4,5};
        int[] popA = new int[] {4,5,3,2,1};

        Solution solution = new Solution();
        System.out.println(solution.IsPopOrder(pushA, popA));
        popA = new int[] {4,3,5,1,2};
        System.out.println(solution.IsPopOrder(pushA, popA));
        popA = new int[] {4,3,5,2,1};
        System.out.println(solution.IsPopOrder(pushA, popA));
    }

}
