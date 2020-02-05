package com.siwuxie095.onlineprogramming.huawei.question028;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 素数伴侣
 *
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
 * 现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选
 * 方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而
 * 将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学
 * 会希望你寻找出“最佳方案”。
 *
 * 输入:
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 *
 * 输出:
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 *
 * 输出描述:
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 * 示例1
 *
 * 输入
 * 4
 * 2 5 6 13
 *
 * 输出
 * 2
 *
 * @author Jiajing Li
 * @date 2020-02-05 17:33:14
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(scanner.next());
            }
            // divide to even and odd
            List<Integer> evenList = new ArrayList<>();
            List<Integer> oddList = new ArrayList<>();
            for (int num : arr) {
                if (num % 2 == 0) {
                    evenList.add(num);
                } else {
                    oddList.add(num);
                }
            }
            // evenMatch[i] means the an even number matched an odd number.
            int[] evenMatchOdd = new int[evenList.size()];
            int res = 0;
            for (int oddNum : oddList) {
                // matched or not
                int[] matched = new int[evenList.size()];
                if (match(oddNum, evenList, matched, evenMatchOdd)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    private static boolean match(int oddNum, List<Integer> evenList, int[] matched, int[] evenMatchOdd) {
        for (int i = 0; i < evenList.size(); i++) {
            int evenNum = evenList.get(i);
            if (isPrime(oddNum + evenNum) && matched[i] == 0) {
                matched[i] = 1;
                if (evenMatchOdd[i] == 0 || match(evenMatchOdd[i], evenList, matched, evenMatchOdd)) {
                    evenMatchOdd[i] = oddNum;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
            if (num == 1) {
                return false;
            }
        }
        return true;
    }

}
