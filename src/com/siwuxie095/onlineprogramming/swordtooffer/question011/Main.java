package com.siwuxie095.onlineprogramming.swordtooffer.question011;

/**
 * @author Jiajing Li
 * @date 2021-04-06 10:47:12
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + solution.NumberOf1(i));
        }
    }

}
