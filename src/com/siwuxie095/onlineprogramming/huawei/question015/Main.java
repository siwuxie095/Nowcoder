package com.siwuxie095.onlineprogramming.huawei.question015;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 *
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 * 这个数转换成2进制后，输出1的个数
 *
 *
 * 示例1
 *
 * 输入
 * 5
 *
 * 输出
 * 2
 *
 * @author Jiajing Li
 * @date 2019-12-01 14:44:34
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        int count = 0;
        while (val != 0) {
            int remainder = val % 2;
            val = val / 2;
            if (remainder == 1) {
                count++;
            }
        }
        System.out.println(count);
    }

}
