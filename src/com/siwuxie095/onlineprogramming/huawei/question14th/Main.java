package com.siwuxie095.onlineprogramming.huawei.question14th;

import java.util.*;

/**
 * 字串的连接最长路径查找
 *
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 *
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 *
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 *
 *
 * 示例1
 *
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 *
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 *
 * @author Jiajing Li
 * @date 2019-12-01 13:58:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(scanner.next());
        }
        Collections.sort(list);
        for (String str : list) {
            System.out.println(str);
        }
    }

}
