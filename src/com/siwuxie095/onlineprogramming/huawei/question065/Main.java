package com.siwuxie095.onlineprogramming.huawei.question065;

import java.util.Scanner;

/**
 * 查找两个字符串a,b中的最长公共子串
 *
 * 题目描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 返回重复出现的字符
 *
 *
 * 示例1
 *
 * 输入
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 *
 * 输出
 * jklmnop
 *
 * @author Jiajing Li
 * @date 2020-04-12 18:06:26
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            String longer = str1.length() >= str2.length() ? str1 : str2;
            String shorter = str1.length() >= str2.length() ? str2 : str1;
            int len = 0;
            String common = "";
            for (int i = 0; i < shorter.length(); i++) {
                for (int j = i + 1; j <= shorter.length(); j++) {
                    String substring = shorter.substring(i, j);
                    if (longer.contains(substring) && j - i > len) {
                        len = j - i;
                        common = substring;
                    }
                }
            }
            System.out.println(common);
        }
    }

}
