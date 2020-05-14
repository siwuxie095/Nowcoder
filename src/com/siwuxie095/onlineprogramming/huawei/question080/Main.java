package com.siwuxie095.onlineprogramming.huawei.question080;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 整形数组合并
 *
 * 题目描述
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素
 *
 * 输入描述:
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述:
 * 输出合并之后的数组
 *
 *
 * 示例1
 *
 * 输入
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 *
 * 输出
 * -101235
 *
 * @author Jiajing Li
 * @date 2020-05-14 10:41:21
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int firstLen = scanner.nextInt();
            int[] firstArr = new int[firstLen];
            for (int i = 0; i < firstLen; i++) {
                firstArr[i] = scanner.nextInt();
            }
            int secondLen = scanner.nextInt();
            int[] secondArr = new int[secondLen];
            for (int i = 0; i < secondLen; i++) {
                secondArr[i] = scanner.nextInt();
            }
            Arrays.sort(firstArr);
            Arrays.sort(secondArr);
            int firstIndex = 0;
            int secondIndex = 0;
            List<Integer> list = new ArrayList<>();
            while (firstIndex < firstLen || secondIndex < secondLen) {
                if (firstIndex >= firstLen) {
                    list.add(secondArr[secondIndex++]);
                } else if (secondIndex >= secondLen) {
                    list.add(firstArr[firstIndex++]);
                } else {
                    if (firstArr[firstIndex] <= secondArr[secondIndex]) {
                        list.add(firstArr[firstIndex++]);
                    } else {
                        list.add(secondArr[secondIndex++]);
                    }
                }
            }
            list = list.stream().distinct().collect(Collectors.toList());
            for (int val : list) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

}
