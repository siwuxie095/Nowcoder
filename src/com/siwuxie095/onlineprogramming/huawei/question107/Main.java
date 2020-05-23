package com.siwuxie095.onlineprogramming.huawei.question107;

import java.util.Scanner;

/**
 * 求解立方根
 *
 * 题目描述
 * •计算一个数字的立方根，不使用库函数
 *
 * 输入描述:
 * 待求解参数 double类型
 *
 * 输出描述:
 * 输入参数的立方根 也是double类型
 *
 *
 * 示例1
 *
 * 输入
 * 216
 *
 * 输出
 * 6.0
 *
 * @author Jiajing Li
 * @date 2020-05-23 13:02:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()){
            double pow = scanner.nextDouble();
            double num = 1.0;
            for (; Math.abs(Math.pow(num, 3) - pow) > 1e-3; num = num - ((Math.pow(num, 3) - pow) / (3 * Math.pow(num, 2)))) {

            }
            System.out.println(String.format("%.1f", num));
        }
    }

}
