package com.siwuxie095.onlineprogramming.swordtooffer.question008;

/**
 * @author Jiajing Li
 * @date 2021-03-31 19:36:24
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + solution.JumpFloor(i));
        }
    }

}
