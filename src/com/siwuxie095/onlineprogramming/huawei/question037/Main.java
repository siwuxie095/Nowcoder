package com.siwuxie095.onlineprogramming.huawei.question037;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数
 *
 * 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 输入描述:
 * 输入int型表示 month
 *
 * 输出描述:
 * 输出兔子总数int型
 *
 *
 * 示例1
 *
 * 输入
 * 9
 *
 * 输出
 * 34
 *
 * @author Jiajing Li
 * @date 2020-02-12 14:23:10
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            System.out.println(getTotalCountIteratively(month));
        }
    }

    /**
     * Recursive method.
     */
    private static int getTotalCountRecursively(int month) {
        if (month == 1 || month == 2) {
            return 1;
        }
        return getTotalCountRecursively(month - 1) + getTotalCountRecursively(month - 2);
    }

    /**
     * Iterative method.
     */
    private static int getTotalCountIteratively(int month) {
        if (month < 1) {
            return 0;
        }
        if (month == 1 || month == 2) {
            return 1;
        }
        int res = 0;
        int pre = 1;
        int prepre = 1;
        for (int i = 3; i <= month; ++i) {
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }

}
