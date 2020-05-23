package com.siwuxie095.onlineprogramming.huawei.question103;

import java.util.Scanner;

/**
 * Redraiment的走法
 *
 * 题目描述
 * Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，
 * 但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？
 *
 *
 * 样例输入
 * 6
 * 2 5 1 5 4 5
 *
 * 样例输出
 * 3
 *
 * 提示
 * Example:
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 *
 * 所以这个结果是3。
 *
 *
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 输出结果
 *
 *
 * 示例1
 *
 * 输入
 * 6
 * 2
 * 5
 * 1
 * 5
 * 4
 * 5
 *
 * 输出
 * 3
 *
 * @author Jiajing Li
 * @date 2020-05-23 11:54:51
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = scanner.nextInt();
            }
            int max = -1;
            int[] dp = new int[count];
            for (int i = 0; i < count; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
            System.out.println(max);
        }
    }

}
