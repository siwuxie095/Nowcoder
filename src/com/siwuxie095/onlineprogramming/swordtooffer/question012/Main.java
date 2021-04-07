package com.siwuxie095.onlineprogramming.swordtooffer.question012;

/**
 * @author Jiajing Li
 * @date 2021-04-07 13:49:49
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + solution.Power(2, i));
        }

        Other other = new Other();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + other.Power(2, i));
        }
    }

}
