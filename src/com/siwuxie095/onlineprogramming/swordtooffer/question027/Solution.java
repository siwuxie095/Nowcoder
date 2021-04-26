package com.siwuxie095.onlineprogramming.swordtooffer.question027;

import java.util.*;

/**
 * JZ27 字符串的排列
 *
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc,则按字典序打印出由字符 a,b,c
 * 所能排列出来的所有字符串 abc,acb,bac,bca,cab 和 cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过 9(可能有字符重复),字符只包括大小写字母。
 *
 *
 * 示例1
 *
 * 输入
 * "ab"
 *
 * 返回值
 * ["ab","ba"]
 *
 * @author Jiajing Li
 * @date 2021-04-23 14:07:09
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (null == str || str.length() == 0) {
            return list;
        }
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        getAllPermutation(arr, list);
        Set<String> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    private static void getAllPermutation(char[] arr, List<String> groupList) {
        int count = 1;
        for (int i = 2; i <= arr.length; i++) {
            count *= i;
        }
        groupList.add(new String(arr));
        for (int i = 0; i < count - 1; i++) {
            getNextPermutation(arr);
            char[] group = Arrays.copyOf(arr, arr.length);
            groupList.add(new String(group));
        }
    }

    private static void getNextPermutation(char[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[i] < arr[j]) {
                        swap(arr, i, j);
                        reverse(arr, i + 1, arr.length);
                        return;
                    }
                }
            }
        }
        // 特别的，数组已经从大到小排列好，reverse数组得到下一个排列
        reverse(arr, 0, arr.length);
    }

    private static void reverse(char[] arr, int startIndexInclusive, int endIndexExclusive) {
        if (null == arr) {
            return;
        }
        int i = Math.max(0, startIndexInclusive);
        int j = Math.min(arr.length, endIndexExclusive) - 1;
        while (j > i) {
            swap(arr, i, j);
            j--;
            i++;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp;
        tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}
