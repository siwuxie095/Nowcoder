package com.siwuxie095.onlineprogramming.huawei.question13th;

import java.util.Scanner;

/**
 * 句子逆序
 *
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 输入描述:
 * 将一个英文语句以单词为单位逆序排放。
 *
 * 输出描述:
 * 得到逆序的句子
 *
 *
 * 示例1
 *
 * 输入
 * I am a boy
 *
 * 输出
 * boy a am I
 *
 * @author Jiajing Li
 * @date 2019-12-01 13:47:59
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

}
