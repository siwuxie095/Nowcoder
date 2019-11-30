package com.siwuxie095.onlineprogramming.huawei.question7th;

import java.util.Scanner;

/**
 * 取近似值
 *
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 *
 * 示例1
 *
 * 输入
 * 5.5
 *
 * 输出
 * 6
 *
 * @author Jiajing Li
 * @date 2019-11-30 18:03:53
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double val = scanner.nextDouble();
        long res = Math.round(val);
        System.out.println(res);
    }

}
