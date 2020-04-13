package com.siwuxie095.onlineprogramming.huawei.question067;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 24点游戏算法
 *
 * 题目描述
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字]
 * 输出：
 * true or false
 *
 * 输入描述:
 * 输入4个int整数
 *
 * 输出描述:
 * 返回能否得到24点，能输出true，不能输出false
 *
 *
 * 示例1
 *
 * 输入
 * 7 2 1 10
 *
 * 输出
 * true
 *
 * @author Jiajing Li
 * @date 2020-04-12 19:44:45
 */
public class Main {

    private static final int LENGTH = 4;
    private static final int TARGET = 24;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr = new int[LENGTH];
            for (int i = 0; i < LENGTH; i++) {
                arr[i] = scanner.nextInt();
            }

            boolean flag = false;
            for (int i = 0; i < LENGTH; i++) {
                for (int j = 0; j < LENGTH; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < LENGTH; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        for (int l = 0; l < LENGTH; l++) {
                            if (l == i || l == j || l == k) {
                                continue;
                            }
                            int[] num = new int[LENGTH];
                            num[0] = arr[i];
                            num[1] = arr[j];
                            num[2] = arr[k];
                            num[3] = arr[l];
                            int[] used = new int[LENGTH];
                            double res = 0.0D;
                            if (judge(num, used, res)) {
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(flag);
        }
    }

    private static boolean judge(int[] num, int[] used, double res) {
        for (int i = 0; i < num.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                if (judge(num, used, res + num[i])
                        || judge(num, used, res - num[i])
                        || judge(num, used, res * num[i])
                        || judge(num, used, res / num[i])) {
                    return true;
                }
                used[i] = 0;
            }
        }
        return res == TARGET;
    }

}
