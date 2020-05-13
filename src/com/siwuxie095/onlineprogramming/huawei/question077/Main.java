package com.siwuxie095.onlineprogramming.huawei.question077;

import java.util.*;

/**
 * 火车进站
 *
 * 题目描述
 *
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。
 * 要求以字典序排序输出火车出站的序列号。
 *
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 *
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 *
 * 示例1
 *
 * 输入
 * 3
 * 1 2 3
 *
 * 输出
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 *
 * @author Jiajing Li
 * @date 2020-05-11 15:32:16
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
            int[] sortArr = arr.clone();
            Arrays.sort(sortArr);
            List<int[]> groupList = new ArrayList<>();
            getAllPermutation(sortArr, 0, count, groupList);

            StringBuilder builder = new StringBuilder();
            Set<String> set = new TreeSet<>();
            for (int[] group : groupList) {
                boolean matched = isMatched(arr, group);
                if (matched) {
                    for (int val : group) {
                        builder.append(val);
                        builder.append(" ");
                    }
                    String str = builder.toString();
                    set.add(str.substring(0, str.length() - 1));
                   builder.setLength(0);
                }
            }

            for (String s : set) {
                System.out.println(s);
            }
        }
    }

    private static boolean isMatched(int[] arr, int[] group) {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        boolean flag = true;
        for (int val : arr) {
            if (group[index] == val) {
                index++;
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(val);
            } else {
                while (!stack.isEmpty() && group[index] == stack.peek()) {
                    stack.pop();
                    index++;
                }
                stack.push(val);
            }

        }
        while (!stack.isEmpty()) {
            if (stack.pop() != group[index]) {
                flag = false;
                break;
            }
            index++;
        }
        return flag;
    }

    private static void getAllPermutation(int[] arr, int startIdx, int length, List<int[]> groupList) {
        if (startIdx == length - 1) {
            int[] group = arr.clone();
            groupList.add(group);
            return;
        }
        for(int currentIdx = startIdx; currentIdx < length; currentIdx++) {
            swap(arr, startIdx, currentIdx);
            getAllPermutation(arr,startIdx + 1 , length, groupList);
            swap(arr, startIdx, currentIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp;
        tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}