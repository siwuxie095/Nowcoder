package com.siwuxie095.onlineprogramming.huawei.question010;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符个数统计
 *
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，
 * 不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 *
 * 示例1
 *
 * 输入
 * abc
 *
 * 输出
 * 3
 *
 * @author Jiajing Li
 * @date 2019-12-01 13:13:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : arr) {
            // 0~127 and not contains newline.
            if (ch >= 0 && ch <= 127 && ch != 10) {
                set.add(ch);
            }
        }
        System.out.println(set.size());
    }

}
