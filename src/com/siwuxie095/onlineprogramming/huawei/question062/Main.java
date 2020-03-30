package com.siwuxie095.onlineprogramming.huawei.question062;

import java.util.Scanner;

/**
 * 查找输入整数二进制中1的个数
 *
 * 题目描述
 * 请实现如下接口
 * public static int findNumberOf1( int num)
 * {
 * return 0;
 * }
 * 譬如：输入5 ，5的二进制为101，输出2
 *
 *
 * 涉及知识点：
 * 注意多组输入输出！！！！！！
 *
 * 输入描述:
 * 输入一个整数
 *
 * 输出描述:
 * 计算整数二进制中1的个数
 *
 *
 * 示例1
 *
 * 输入
 * 5
 *
 * 输出
 * 2
 *
 * @author Jiajing Li
 * @date 2020-03-28 21:12:24
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            int count = 0;
            while (value != 0) {
                int remainder = value % 2;
                value = value / 2;
                if (remainder == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
