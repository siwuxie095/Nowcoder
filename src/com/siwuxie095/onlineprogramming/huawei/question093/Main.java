package com.siwuxie095.onlineprogramming.huawei.question093;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 201301 JAVA题目0-1级
 *
 * 题目描述
 * 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，并且，
 * 所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，返回
 * true；不满足时返回false。
 *
 * 输入描述:
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述:
 * 返回true或者false
 *
 *
 * 示例1
 *
 * 输入
 * 4
 * 1 5 -5 1
 *
 * 输出
 * true
 *
 * @author Jiajing Li
 * @date 2020-05-19 16:59:30
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
           int count = scanner.nextInt();
           List<Integer> list = new ArrayList<>();
           for (int i = 0; i < count; i++) {
               list.add(scanner.nextInt());
           }
           List<Integer> fiveGroup = new ArrayList<>();
           List<Integer> threeGroup = new ArrayList<>();
           for (int val : list) {
               if (val % 5 == 0) {
                   fiveGroup.add(val);
               }
               if (val % 3 == 0) {
                   threeGroup.add(val);
               }
           }
           list = list.stream().filter(x -> x % 5 != 0 && x % 3 != 0).sorted().collect(Collectors.toList());
           int fiveSum = fiveGroup.stream().mapToInt(x -> x).sum();
           int threeSum = threeGroup.stream().mapToInt(x -> x).sum();
           System.out.println(judge(fiveSum, threeSum, list, 0));
        }
    }

    private static boolean judge(int fiveSum, int threeSum, List<Integer> list, int index) {
        if (fiveSum == threeSum && index == list.size()) {
            return true;
        }
        if (fiveSum != threeSum && index == list.size()) {
            return false;
        }
        return judge(fiveSum + list.get(index), threeSum, list, index + 1) || judge(fiveSum, threeSum + list.get(index), list, index + 1);
    }

}
