package com.siwuxie095.onlineprogramming.huawei.question104;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串分割
 *
 * 题目描述
 * 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 首先输入一个整数，为要输入的字符串个数。
 *
 * 例如：
 * 输入：2
 *       abc
 *       12345789
 * 输出：abc00000
 *       12345678
 *       90000000
 *
 * 输入描述:
 * 首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。
 *
 * 输出描述:
 * 按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 *
 * 示例1
 *
 * 输入
 * 2
 * abc
 * 123456789
 *
 * 输出
 * abc00000
 * 12345678
 * 90000000
 *
 * @author Jiajing Li
 * @date 2020-05-23 12:20:35
 */
public class Main {

    private static int SPLIT_LEN = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            String[] arr = new String[count];
            for (int i = 0; i < count; i++) {
                arr[i] = scanner.next();
            }
            List<String> resList = new ArrayList<>();
            for (String str : arr) {
                buildResultList(str, resList);
            }
            for (String res : resList) {
                System.out.println(res);
            }
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
