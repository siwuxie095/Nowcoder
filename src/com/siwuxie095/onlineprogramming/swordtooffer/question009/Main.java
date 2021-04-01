package com.siwuxie095.onlineprogramming.swordtooffer.question009;

/**
 * @author Jiajing Li
 * @date 2021-04-01 10:53:19
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + solution.jumpFloorII(i));
        }
    }

}
