package com.siwuxie095.onlineprogramming.huawei.question034;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 图片整理
 *
 * 题目描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小
 * （ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 *
 * 输入描述:
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 *
 * 输出描述:
 * Lily的所有图片按照从小到大的顺序输出
 *
 *
 * 示例1
 *
 * 输入
 * Ihave1nose2hands10fingers
 *
 * 输出
 * 0112Iaadeeefghhinnnorsssv
 *
 * @author Jiajing Li
 * @date 2020-02-10 11:12:20
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] chArr = input.toCharArray();
            List<Integer> list = new ArrayList<>();
            for (char ch : chArr) {
                list.add((int) ch);
            }
            Collections.sort(list);
            StringBuilder builder = new StringBuilder();
            for (int val : list) {
                builder.append((char) val);
            }
            System.out.println(builder);
        }
    }

}
