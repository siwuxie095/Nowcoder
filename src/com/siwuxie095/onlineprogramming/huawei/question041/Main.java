package com.siwuxie095.onlineprogramming.huawei.question041;

import java.util.*;

/**
 * 称砝码
 *
 * 题目描述
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，
 * 问能称出多少种不同的重量。
 *
 * 注：
 * 称重重量包括0
 *
 * 方法原型：public static int fama(int n, int[] weight, int[] nums)
 *
 *
 * 输入描述:
 * 输入包含多组测试数据。
 *
 * 对于每组测试数据：
 * 第一行：n --- 砝码数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 *
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 *
 *
 * 示例1
 *
 * 输入
 * 2
 * 1 2
 * 2 1
 *
 * 输出
 * 5
 *
 * @author Jiajing Li
 * @date 2020-02-16 21:51:17
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int total = scanner.nextInt();
            int[] weights = new int[total];
            int[] numbers = new int[total];
            for (int i = 0; i < total; i++) {
                weights[i] = scanner.nextInt();
            }
            for (int i = 0; i < total; i++) {
                numbers[i] = scanner.nextInt();
            }
            // result set
            Set<Integer> set = new HashSet<>();
            // add the first weight of all situation. note that 0 also in the result set.
            for (int i = 0; i <= numbers[0]; i++) {
                set.add(weights[0] * i);
            }
            // add the other weight of all situation.
            for (int i = 1; i < total; i++) {
                List<Integer> list = new ArrayList<>(set);
                for (int j = 0; j <= numbers[i]; j++) {
                    for (int k = 0; k < list.size(); k++) {
                        set.add(list.get(k) + weights[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }



}
