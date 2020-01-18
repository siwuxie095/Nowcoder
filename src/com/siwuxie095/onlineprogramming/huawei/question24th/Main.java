package com.siwuxie095.onlineprogramming.huawei.question24th;

import java.util.Scanner;

/**
 * 合唱队
 *
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。合唱队形是指
 * 这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，则他们的身
 * 高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。你的任务是，已知所有N位同学
 * 的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 输入描述:
 * 整数N
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 *
 * 复制
 * 8
 * 186 186 150 200 160 130 197 200
 *
 * 输出
 * 4
 *
 * @author Jiajing Li
 * @date 2020-01-18 16:23:58
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();

            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = scanner.nextInt();
            }
            // longest increment sub sequence.
            int[] incr = new int[num];
            // longest decrement sub sequence.
            int[] decr = new int[num];

            // left to right
            incr[0] = 1;
            for (int i = 1; i < num; i++) {
                incr[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && incr[j] + 1 > incr[i]) {
                        incr[i] = incr[j] + 1;
                    }
                }
            }
            // right to left
            decr[num - 1] = 1;
            for (int i = num - 2; i >= 0; i--) {
                decr[i] = 1;
                for (int j = num - 1; j > i; j--) {
                    if (arr[j] < arr[i] && decr[j] + 1 > decr[i]) {
                        decr[i] = decr[j] + 1;
                    }
                }
            }
            // combine
            int tmp = 0;
            for (int i = 0; i < num; i++) {
                if (incr[i] + decr[i] - 1 > tmp) {
                    tmp = incr[i] + decr[i] - 1;
                }
            }
            System.out.println(num - tmp);
        }
    }


}
