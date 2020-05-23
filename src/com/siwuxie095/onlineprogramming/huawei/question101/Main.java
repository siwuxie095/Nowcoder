package com.siwuxie095.onlineprogramming.huawei.question101;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 题目描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * （一组测试用例可能会有多组数据）
 *
 *
 * 输入描述:
 * 1、输入需要输入的整型数个数
 *
 * 输出描述:
 * 输出排好序的数字
 *
 *
 * 示例1
 *
 * 输入
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 *
 * 输出
 * 1 2 3 4 9 25 55 64
 *
 * @author Jiajing Li
 * @date 2020-05-23 10:44:14
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
            boolean asc = scanner.nextInt() == 0;
            if (asc) {
                list.sort(Comparator.naturalOrder());
            } else {
                list.sort(Comparator.reverseOrder());
            }
            StringBuilder res = new StringBuilder();
            for (int val : list) {
                res.append(val);
                res.append(" ");
            }
            String str = res.toString();
            System.out.println(str.substring(0, str.length() - 1));
        }
    }

}
