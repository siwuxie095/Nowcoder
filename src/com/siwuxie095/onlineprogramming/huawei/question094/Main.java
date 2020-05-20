package com.siwuxie095.onlineprogramming.huawei.question094;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 记票统计
 *
 * 题目描述
 * 请实现接口：
 *
 * unsigned int  AddCandidate (char* pCandidateName);
 * 功能：设置候选人姓名
 * 输入： char* pCandidateName 候选人姓名
 * 输出：无
 * 返回：输入值非法返回0，已经添加过返回0 ，添加成功返回1
 *
 *
 * 输入描述:
 * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 每行输出候选人的名字和得票数量。
 *
 *
 * 示例1
 *
 * 输入
 * 4
 * A B C D
 * 8
 * A B C D E F G H
 *
 * 输出
 * A : 1
 * B : 1
 * C : 1
 * D : 1
 * Invalid : 4
 *
 * @author Jiajing Li
 * @date 2020-05-19 18:08:48
 */
public class Main {

    private static final String INVALID = "Invalid";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int candidateCount = scanner.nextInt();
            Map<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < candidateCount; i++) {
                map.put(scanner.next(), 0);
            }
            map.put(INVALID, 0);
            int voteCount = scanner.nextInt();
            int invalidCount = 0;
            for (int i = 0; i < voteCount; i++) {
                String candidate = scanner.next();
                if (map.containsKey(candidate)) {
                    map.put(candidate, map.get(candidate) + 1);
                } else {
                    map.put(INVALID, map.get(INVALID) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

}
