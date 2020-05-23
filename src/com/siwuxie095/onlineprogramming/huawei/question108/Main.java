package com.siwuxie095.onlineprogramming.huawei.question108;

import java.util.Scanner;

/**
 * 求最小公倍数
 *
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，
 * 设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 *
 * 示例1
 *
 * 输入
 * 5 7
 *
 * 输出
 * 35
 *
 * @author Jiajing Li
 * @date 2020-05-23 14:11:00
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            if (first % second == 0) {
                System.out.println(first);
            } else if (second % first == 0) {
                System.out.println(second);
            } else {
                if (first % 2 == 0 && second % 2 == 0) {
                    printNum(first * second, first, second, 2);
                } else if (first % 3 == 0 && second % 3 == 0) {
                    printNum(first * second, first, second, 3);
                } else {
                    System.out.println(first * second);
                }
            }
        }
    }

    private static void printNum(int num, int first, int second, int divisor) {
        if (num / divisor % first == 0 && num / divisor % second == 0) {
            printNum(num / divisor, first, second, divisor);
        } else {
            System.out.println(num);
        }
    }

}
