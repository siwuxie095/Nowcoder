package com.siwuxie095.onlineprogramming.huawei.question009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 提取不重复的整数
 *
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 *
 * 示例1
 *
 * 输入
 * 9876673
 *
 * 输出
 * 37689
 *
 * @author Jiajing Li
 * @date 2019-12-01 12:50:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        String str = String.valueOf(val);
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
        }
        int res = Integer.valueOf(builder.toString());
        System.out.println(res);
    }

}
