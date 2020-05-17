package com.siwuxie095.onlineprogramming.huawei.question086;

import java.util.Scanner;

/**
 * 求最大连续bit数
 *
 * 题目描述
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 输入: 一个byte型的数字
 * 输出: 无
 * 返回: 对应的二进制数字中1的最大连续数
 *
 * 输入描述:
 * 输入一个byte数字
 *
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 *
 *
 * 示例1
 *
 * 输入
 * 3
 *
 * 输出
 * 2
 *
 * @author Jiajing Li
 * @date 2020-05-15 17:45:13
 */
public class Main {

    public static void main(String[] args) {
        normalMethod();
        //betterMethod();
    }

    private static void normalMethod() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int val = scanner.nextInt();
            int serialCount = 0;
            int resettableCount = 0;
            boolean flag = false;
            while (val != 0) {
                int remainder = val % 2;
                val = val / 2;
                if (remainder == 1) {
                    if (!flag) {
                        flag = true;
                    }
                    resettableCount++;
                    serialCount = Math.max(serialCount, resettableCount);
                } else {
                    flag = false;
                    resettableCount = 0;
                }
            }
            System.out.println(serialCount);
        }
    }

    private static void betterMethod() {
        Scanner scanner = new Scanner(System.in);
        // val 变为 0 的次数，取决于 val 中连续 1 的个数
        while (scanner.hasNext()) {
            int val = scanner.nextInt();
            int count = 0;
            for (; val != 0; count++) {
                val = val & (val << 1);
            }
            System.out.println(count);
        }
    }


}
