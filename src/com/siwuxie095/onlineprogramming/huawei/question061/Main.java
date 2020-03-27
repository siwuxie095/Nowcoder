package com.siwuxie095.onlineprogramming.huawei.question061;

import java.util.Scanner;

/**
 * 放苹果
 *
 * 题目描述
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * （用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 输入
 * 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
 *
 * 样例输入
 * 7 3
 *
 * 样例输出
 * 8
 *
 *
 * 输入描述:
 * 输入两个int整数
 *
 * 输出描述:
 * 输出结果，int型
 *
 *
 * 示例1
 *
 * 输入
 * 7 3
 *
 * 输出
 * 8
 *
 * @author Jiajing Li
 * @date 2020-03-27 10:52:00
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int appleCount = scanner.nextInt();
            int dishCount = scanner.nextInt();
            int res = count(appleCount, dishCount);
            System.out.println(res);
        }
    }

    /**
     * Func(appleCount, dishCount) =  Func(appleCount, dishCount - 1) + Func(appleCount - dishCount, dishCount)
     */
    private static int count(int appleCount, int dishCount) {
        if (appleCount < 0) {
            return 0;
        }
        if (appleCount == 0 || dishCount == 1) {
            return 1;
        }
        return count(appleCount, dishCount - 1) + count(appleCount - dishCount, dishCount);
    }

}
