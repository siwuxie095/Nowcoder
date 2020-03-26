package com.siwuxie095.onlineprogramming.huawei.question059;

import java.util.*;

/**
 * 找出字符串中第一个只出现一次的字符
 *
 * 题目描述
 * 找出字符串中第一个只出现一次的字符
 *
 * 输入描述:
 * 输入一个非空字符串
 *
 * 输出描述:
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 *
 * 示例1
 *
 * 输入
 * asdfasdfo
 *
 * 输出
 * o
 *
 * @author Jiajing Li
 * @date 2020-03-26 09:35:46
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            Character ch = getFirstChar(str);
            if (Objects.isNull(ch)) {
                System.out.println(-1);
            } else {
                System.out.println(ch);
            }
        }
    }

    private static Character getFirstChar(String str) {
        char[] arr = str.toCharArray();
        Set<Character> existedSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!existedSet.contains(arr[i]) && nonFindSameChar(arr[i], i + 1, arr)) {
                return arr[i];
            }
            existedSet.add(arr[i]);
        }
        return null;
    }

    private static boolean nonFindSameChar(char currCh, int nextIdx, char[] arr) {
        for (int i = nextIdx; i < arr.length; i++) {
            if (currCh == arr[i]) {
                return false;
            }
        }
        return true;
    }

}
