package com.siwuxie095.onlineprogramming.huawei.question084;

import java.util.Scanner;

/**
 * 统计大写字母个数
 *
 * 题目描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数
 *
 *
 * 输入描述:
 * 输入一个String数据
 *
 * 输出描述:
 * 输出string中大写字母的个数
 *
 *
 * 示例1
 *
 * 输入
 * add123#$%#%#O
 *
 * 输出
 * 1
 *
 * @author Jiajing Li
 * @date 2020-05-15 15:37:23
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int count = 0;
            for (char ch : str.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
