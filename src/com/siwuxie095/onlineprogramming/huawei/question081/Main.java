package com.siwuxie095.onlineprogramming.huawei.question081;

import java.util.Scanner;

/**
 * 字符串匹配
 *
 * 题目描述:
 * 判断短字符串中的所有字符是否在长字符串中全部出现
 *
 *
 * 输入描述:
 * 输入两个字符串。第一个为短字符，第二个为长字符。
 *
 * 输出描述:
 * true / false
 *
 *
 * 示例1
 *
 * 输入
 * bc
 * abc
 *
 * 输出
 * true
 *
 * @author Jiajing Li
 * @date 2020-05-14 14:45:37
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String shortStr = scanner.next();
            String longStr = scanner.next();
            boolean flag = true;
            for (char ch : shortStr.toCharArray()) {
                if (!longStr.contains(Character.toString(ch))) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
    }

}
