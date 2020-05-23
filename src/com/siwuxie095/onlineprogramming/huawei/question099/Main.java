package com.siwuxie095.onlineprogramming.huawei.question099;

import java.util.Scanner;

/**
 * 自守数
 *
 * 题目描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，
 * 9376^2 = 87909376。请求出n以内的自守数的个数
 *
 *
 * 输入描述:
 * int型整数
 *
 * 输出描述:
 * n以内自守数的数量。
 *
 *
 * 示例1
 *
 * 输入
 * 2000
 *
 * 输出
 * 8
 *
 * @author Jiajing Li
 * @date 2020-05-23 10:10:15
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int limit = scanner.nextInt();
            int count = 0;
            for (int i = 0; i <= limit; i++) {
                if (isMatch(String.valueOf(i), String.valueOf((int) Math.pow(i, 2)))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isMatch(String num, String pow) {
        char[] numArr = num.toCharArray();
        char[] powArr = pow.toCharArray();
        int numIndex = numArr.length - 1;
        int powIndex = powArr.length - 1;
        while (numIndex >= 0) {
            if (numArr[numIndex] == powArr[powIndex]) {
                numIndex--;
                powIndex--;
            } else {
                break;
            }
        }
        return numIndex < 0;
    }

}
