package com.siwuxie095.onlineprogramming.huawei.question100;

import java.util.Scanner;

/**
 * 等差数列
 *
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 * 输入:正整数N > 0
 * 输出:求等差数列前N项和
 * 返回:转换成功返回 0 ,非法输入与异常返回-1
 *
 *
 * 输入描述:
 * 输入一个正整数。
 *
 * 输出描述:
 * 输出一个相加后的整数。
 *
 *
 * 示例1
 *
 * 输入
 * 2
 *
 * 输出
 * 7
 *
 * @author Jiajing Li
 * @date 2020-05-23 10:30:53
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int first = 2;
            int last = 3 * num - 1;
            System.out.println((first + last) * num / 2);
        }
    }

}
