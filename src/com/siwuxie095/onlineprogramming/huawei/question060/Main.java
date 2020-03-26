package com.siwuxie095.onlineprogramming.huawei.question060;

import java.util.Scanner;

/**
 * 查找组成一个偶数最接近的两个素数
 *
 * 题目描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
 * 本题目要求输出组成指定偶数的两个素数差值最小的素数对
 *
 * 输入描述:
 * 输入一个偶数
 *
 * 输出描述:
 * 输出两个素数
 *
 *
 * 示例1
 *
 * 输入
 * 20
 *
 * 输出
 * 7
 * 13
 *
 * @author Jiajing Li
 * @date 2020-03-26 09:58:55
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int half = num / 2;
            int first;
            int second;
            if (half % 2 == 0) {
                first = half - 1;
                second = half + 1;
            } else {
                first = second = half;
            }
            while (true) {
                if (isPrime(first) && isPrime(second)) {
                    break;
                } else {
                    first -= 2;
                    second += 2;
                }
            }
            System.out.println(first);
            System.out.println(second);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
