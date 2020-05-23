package com.siwuxie095.onlineprogramming.huawei.question106;

import java.util.Scanner;

/**
 * 字符逆序
 *
 * 题目描述
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 * 如：输入“I am a student”，输出“tneduts a ma I”。
 *
 *
 * 输入参数：
 * inputString：输入的字符串
 *
 *
 * 返回值：
 * 输出转换好的逆序字符串
 *
 *
 * 输入描述:
 * 输入一个字符串，可以有空格
 *
 * 输出描述:
 * 输出逆序的字符串
 *
 *
 * 示例1
 *
 * 输入
 * I am a student
 *
 * 输出
 * tneduts a ma I
 *
 * @author Jiajing Li
 * @date 2020-05-23 12:54:07
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
