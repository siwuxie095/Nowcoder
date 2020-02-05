package com.siwuxie095.onlineprogramming.huawei.question012;

import java.util.Scanner;

/**
 * 字符串反转
 *
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
 *
 * 输入描述:
 * 输入N个字符
 *
 * 输出描述:
 * 输出该字符串反转后的字符串
 *
 *
 * 示例1
 *
 * 输入
 * abcd
 *
 * 输出
 * dcba
 *
 * @author Jiajing Li
 * @date 2019-12-01 13:40:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

}
