package com.siwuxie095.onlineprogramming.huawei.question16th;

import java.util.Scanner;

/**
 * 购物单
 *
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，
 * 附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	    附件
 * 电脑	    打印机，扫描仪
 * 书柜	    图书
 * 书桌	    台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不
 * 再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：
 * 用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望
 * 在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 *
 * 设第 j 件物品的价格为 v[j]，重要度为 w[j]，共选中了 k 件物品，编号依次为 j1，j2，……，jk，则所求
 * 的总和为：
 * v[j1]*w[j1] + v[j2]*w[j2] + … + v[jk]*w[jk]。（其中 * 为乘号）
 *
 * 请你帮助王强设计一个满足要求的购物单。
 *
 *
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （<32000）表示总钱数，m （<60）为希望购买物品的个数。）
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（v<10000）， p 表示该物品的重要度（1 ~ 5）， q 表示该物品是主件还是附件。
 * 如果 q = 0，表示该物品为主件，如果 q > 0 ，表示该物品为附件， q 是所属主件的编号）
 *
 *
 * 输出描述:
 *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（<200000）。
 *
 *
 * 示例1
 *
 * 输入
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 *
 * 输出
 * 2200
 *
 * @author Jiajing Li
 * @date 2019-12-15 16:32:14
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 此处总钱数除以 10，后续单价同样除以 10，可以减少循环次数
        int N = scanner.nextInt() / 10;
        int m = scanner.nextInt();
        int[] v = new int[m + 1];
        int[] p = new int[m + 1];
        int[] q = new int[m + 1];
        int[] w = new int[m + 1];
        // 只针对主件，判断附件对应的主件是否已经购买
        boolean[][] flag = new boolean[m + 1][N + 1];
        int[][] res = new int[m + 1][N + 1];
        for (int i = 1; i <= m; i++) {
            v[i] = scanner.nextInt() / 10;
            p[i] = scanner.nextInt();
            q[i] = scanner.nextInt();

            w[i] = v[i] * p[i];
        }

        /*
         * 动态规划思想
         *
         * i 表示第几件物品
         * j 表示可支配的钱
         */
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= N; j++) {
                    // 主件
                if(q[i] == 0) {
                    // 当前物品价格有足够的钱支付
                    if(v[i] <= j && !flag[i][j]) {
                        res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - v[i]] + w[i]);
                        if (res[i - 1][j] < res[i - 1][j - v[i]] + w[i]) {
                            flag[i][j] = true;
                        }
                    }
                    // 附件， 此时 q[i] 表示所对应的主件的编号
                } else {
                    // 附件的价值加上主件的价值不大于可支配的钱，即可以一起购买附件
                    if(v[i] + v[q[i]] <= j) {
                        if (flag[q[i]][j]) {
                            res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - v[i]] + w[i]);
                        } else {
                            res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - v[i] - v[q[i]]] + w[i] + w[q[i]]);
                            if (res[i - 1][j] < res[i - 1][j - v[i]] + w[i] + w[q[i]]) {
                                flag[q[i]][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res[m][N] * 10);
    }

}
