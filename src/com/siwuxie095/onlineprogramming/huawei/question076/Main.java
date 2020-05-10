package com.siwuxie095.onlineprogramming.huawei.question076;

import java.util.Scanner;

/**
 * 尼科彻斯定理
 *
 * 题目描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 输出分解后的string
 *
 *
 * 示例1
 *
 * 输入
 * 6
 *
 * 输出
 * 31+33+35+37+39+41
 *
 * @author Jiajing Li
 * @date 2020-05-10 18:12:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int squre = num * num;
            StringBuilder builder = new StringBuilder();
            int start = squre - num + 1;

            for (int i = 0; i < num; i++) {
                builder.append(start + i * 2);
                builder.append("+");
            }
            String str = builder.toString();
            System.out.println(str.substring(0,str.length() - 1));
        }
    }

}
