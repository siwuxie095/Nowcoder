package com.siwuxie095.onlineprogramming.huawei.question058;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 输入 n 个整数，输出其中最小的 k 个
 *
 * 题目描述
 * 输入 n 个整数，输出其中最小的 k 个。
 *
 * 输入描述:
 * 输入说明
 * 1 输入两个整数
 * 2 输入一个整数数组
 *
 * 输出描述:
 * 输出一个整数数组
 *
 *
 * 示例1
 *
 * 输入
 * 5 2
 * 1 3 5 7 2
 *
 * 输出
 * 1 2
 *
 * @author Jiajing Li
 * @date 2020-03-25 22:39:29
 */
public class Main {

    /**
     * a better way is to use min-heap.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            list.sort(Comparator.naturalOrder());
            for (int i = 0; i < n; i++) {
                if (i < k) {
                    if (i == k - 1) {
                        System.out.println(list.get(i));
                    } else {
                        System.out.print(list.get(i) + " ");
                    }
                }
            }
        }
    }

}
