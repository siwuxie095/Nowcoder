package com.siwuxie095.onlineprogramming.huawei.question003;

import java.util.*;

/**
 * 明明的随机数
 *
 * 题目描述
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的
 * 随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生
 * 的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”
 * 的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 * Input Param
 *
 * n               输入随机数的个数
 * inputArray      n个随机整数组成的数组
 *
 *
 * Return Value
 *
 * OutputArray    输出处理后的随机整数
 *
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 *
 *
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 返回多行，处理后的结果
 *
 *
 * 示例1
 *
 * 输入
 * 11
 * 10
 * 20
 * 40
 * 32
 * 67
 * 40
 * 20
 * 89
 * 300
 * 400
 * 15
 *
 * 输出
 * 10
 * 15
 * 20
 * 32
 * 40
 * 67
 * 89
 * 300
 * 400
 *
 * @author Jiajing Li
 * @date 2019-11-30 16:27:59
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // because there is multi data group, so we need a while loop.
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < count; i++) {
                set.add(scanner.nextInt());
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for (Integer val : list) {
                System.out.println(val);
            }
        }
    }

}
