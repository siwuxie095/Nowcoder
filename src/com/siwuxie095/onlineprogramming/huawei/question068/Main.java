package com.siwuxie095.onlineprogramming.huawei.question068;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 成绩排序
 *
 * 题目描述
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 * smith     67
 * Tom       70
 * jack      70
 * peter     96
 *
 * 注：0代表从高到低，1代表从低到高
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 *
 * 示例1
 *
 * 输入
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 *
 * 输出
 * fang 90
 * ning 70
 * yang 50
 *
 * @author Jiajing Li
 * @date 2020-04-13 10:41:00
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            // asc = 1  desc = 0
            boolean asc = scanner.nextInt() == 1;
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                User user = new User();
                user.name = scanner.next();
                user.score = scanner.nextInt();
                userList.add(user);
            }
            if (asc) {
                userList.sort(Comparator.comparing(x -> x.score, Comparator.naturalOrder()));
            } else {
                userList.sort(Comparator.comparing(x -> x.score, Comparator.reverseOrder()));
            }
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

}

class User {
    public String name;
    public int score;

    @Override
    public String toString() {
        return name + " " + score;
    }
}
