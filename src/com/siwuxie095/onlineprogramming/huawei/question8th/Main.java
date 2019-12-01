package com.siwuxie095.onlineprogramming.huawei.question8th;

import java.util.*;

/**
 * 合并表记录
 *
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，
 * 输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 *
 * 示例1
 *
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 *
 * 输出
 * 0 3
 * 1 2
 * 3 4
 *
 * @author Jiajing Li
 * @date 2019-12-01 12:39:37
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int element : list) {
            System.out.println(element + " " + map.get(element));
        }
    }

}
