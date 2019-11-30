package com.siwuxie095.onlineprogramming.huawei.question1st;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 *
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 *
 * 示例1
 *
 * 输入
 * hello world
 *
 * 输出
 * 5
 *
 * @author Jiajing Li
 * @date 2019-11-30 16:13:20
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        System.out.print(arr[arr.length - 1].length());
    }

}
