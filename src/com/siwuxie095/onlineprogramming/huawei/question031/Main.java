package com.siwuxie095.onlineprogramming.huawei.question031;

import java.util.Scanner;

/**
 * 密码截取
 *
 * 题目描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，
 * 比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一
 * 些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,
 * 123321->51233214　。因为截获的串太长了，而且存在多种可能的情况
 * （abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，
 * 他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 返回有效密码串的最大长度
 *
 *
 * 示例1
 *
 * 输入
 * ABBA
 *
 * 输出
 * 4
 *
 * @author Jiajing Li
 * @date 2020-02-09 11:56:03
 */
public class Main {

    public static void main(String[] args) {
        /*
         * Using Manacher Algorithm to get longest common palindromic substring
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(maxLcpsLength(input));
        }
    }

    private static int maxLcpsLength(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    private static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }


}
