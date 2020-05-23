package com.siwuxie095.onlineprogramming.huawei.question105;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 记负均正II
 *
 * 题目描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数
 *
 * 输入描述:
 * 输入任意个整数
 *
 * 输出描述:
 * 输出负数个数以及所有非负数的平均值
 *
 *
 * 示例1
 *
 * 输入
 * -13
 * -4
 * -7
 *
 * 输出
 * 3
 * 0.0
 *
 * @author Jiajing Li
 * @date 2020-05-23 12:46:48
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        long negCount = list.stream().filter(x -> x < 0).count();
        long posCount = list.stream().filter(x -> x >= 0).count();
        int posSum = list.stream().filter(x -> x >= 0).mapToInt(x -> x).sum();
        System.out.println(negCount);
        System.out.println(String.format("%.1f", (float) posSum / posCount));
    }

}
