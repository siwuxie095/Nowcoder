package com.siwuxie095.onlineprogramming.huawei.question096;

import java.util.Scanner;

/**
 * 表示数字
 *
 * 题目描述
 * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * public static String MarkNum(String pInStr)
 * {
 * return null;
 * }
 *
 * 注意：输入数据可能有多行
 *
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 *
 * 示例1
 *
 * 输入
 * Jkdi234klowe90a3
 *
 * 输出
 * Jkdi*234*klowe*90*a*3*
 *
 * @author Jiajing Li
 * @date 2020-05-22 09:33:43
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            StringBuilder res = new StringBuilder();
            boolean flag = false;
            int count = 0;
            for (char ch : str.toCharArray()) {
                count++;
                if (Character.isDigit(ch)) {
                    if (!flag) {
                        res.append("*");
                        flag = true;
                    }
                    res.append(ch);
                    if (count == str.length()) {
                        res.append("*");
                    }
                } else {
                    if (flag) {
                        res.append("*");
                        flag = false;
                    }
                    res.append(ch);
                }
            }
            System.out.println(res);
        }
    }

}
