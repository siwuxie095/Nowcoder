package com.siwuxie095.onlineprogramming.huawei.question004;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串分隔
 *
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 *
 * 示例1
 *
 * 输入
 * abc
 * 123456789
 *
 * 输出
 * abc00000
 * 12345678
 * 90000000
 *
 * @author Jiajing Li
 * @date 2019-11-30 16:44:34
 */
public class Main {

    private static int SPLIT_LEN = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        List<String> resList = new ArrayList<>();
        buildResultList(str1, resList);
        buildResultList(str2, resList);

        for (String res : resList) {
            System.out.println(res);
        }
    }

    private static void buildResultList(String str, List<String> resList) {
        int len = str.length();
        int start = 0;
        while (len >= SPLIT_LEN) {
            resList.add(str.substring(start, start + SPLIT_LEN));
            start += SPLIT_LEN;
            len -= SPLIT_LEN;
        }
        if (len > 0) {
            resList.add(str.substring(start) + getReplenishZero(len));
        }
    }

    private static String getReplenishZero(int len) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SPLIT_LEN - len; i++) {
            builder.append("0");
        }
        return builder.toString();
    }

}
