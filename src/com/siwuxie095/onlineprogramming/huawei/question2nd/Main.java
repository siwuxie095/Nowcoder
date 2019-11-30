package com.siwuxie095.onlineprogramming.huawei.question2nd;

import java.util.Scanner;

/**
 * 计算字符个数
 *
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 *
 * 示例1
 *
 * 输入
 * ABCDEF
 * A
 *
 * 输出
 * 1
 *
 *
 * @author Jiajing Li
 * @date 2019-11-30 16:21:34
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourceStr = scanner.nextLine();
        String targetStr = scanner.nextLine();
        char targetChar = targetStr.toUpperCase().toCharArray()[0];
        int count = 0;
        for (char val : sourceStr.toUpperCase().toCharArray()) {
            if (targetChar == val) {
                count++;
            }
        }
        System.out.println(count);
    }

}
