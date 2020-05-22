package com.siwuxie095.onlineprogramming.huawei.question097;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 记负均正
 *
 * 题目描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，
 * 结果保留一位小数。
 *
 * 输入描述:
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 *
 * 输出描述:
 * 输出负数的个数，和所有正整数的平均值。
 *
 *
 * 示例1
 *
 * 输入
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * 输出
 * 0 3
 *
 * @author Jiajing Li
 * @date 2020-05-22 10:54:16
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(scanner.nextInt());
            }
            long negCount = list.stream().filter(x -> x < 0).count();
            long posCount = list.stream().filter(x -> x > 0).count();
            int posSum = list.stream().filter(x -> x > 0).mapToInt(x -> x).sum();
            System.out.println(negCount + " " + String.format("%.1f", (float) posSum / posCount));
        }
    }

}
