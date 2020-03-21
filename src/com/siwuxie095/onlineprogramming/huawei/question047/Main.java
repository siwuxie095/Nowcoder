package com.siwuxie095.onlineprogramming.huawei.question047;

import java.util.*;

/**
 * 线性插值
 *
 * 题目描述
 * 信号测量的结果包括测量编号和测量值。存在信号测量结果丢弃及测量结果重复的情况。
 *
 * 1.测量编号不连续的情况，认为是测量结果丢弃。对应测量结果丢弃的情况，需要进行插值操作以更准确的评估信号。
 * 采用简化的一阶插值方法,由丢失的测量结果两头的测量值算出两者中间的丢失值。
 * 假设第M个测量结果的测量值为A，第N个测量结果的测量值为B。则需要进行(N-M-1)个测量结果的插值处理。进行一阶
 * 线性插值估计的第N+i个测量结果的测量值为A+( (B-A)/(N-M) )*i  (注：N的编号比M大。)
 * 例如：只有测量编号为4的测量结果和测量编号为7的测量结果，测量值分别为4和10 则需要补充测量编号为5和6的测量
 * 结果。
 *     其中测量编号为5的测量值 = 4 + ((10-4)/(7-4))*1 = 6
 *     其中测量编号为6的测量值 = 4 + ((10-4)/(7-4))*2 = 8
 *
 * 2.测量编号相同，则认为测量结果重复，需要对丢弃后来出现的测量结果。
 *
 * 请根据以上规则进行测量结果的整理。
 *
 * 输入描述:
 * 输入说明
 * 1 输入两个整数 m, n
 * 2 输入m个数据组
 *
 * 输出描述:
 * 输出整理后的结果
 *
 *
 * 示例1
 *
 * 输入
 * 2 3
 * 4 5
 * 5 7
 *
 * 输出
 * 4 5
 * 5 7
 *
 * @author Jiajing Li
 * @date 2020-03-21 19:59:50
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            // none is useless, just ignore it
            int none = scanner.nextInt();
            List<String> inputList = new ArrayList<>();
            int lastKey = 0;
            for (int i = 0; i < count; i++) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if (i == 0) {
                    lastKey = key;
                } else {
                    if (key == lastKey) {
                        continue;
                    }
                    lastKey = key;
                }
                inputList.add(key + " " + value);
            }

            int flagKey = 0;
            int flagValue = 0;
            boolean first = true;
            List<String> resList = new ArrayList<>();
            for (String input : inputList) {
                int currKey = Integer.parseInt(input.split(" ")[0]);
                int currValue = Integer.parseInt(input.split(" ")[1]);
                if (first) {
                    flagKey = currKey;
                    flagValue = currValue;
                    first = false;
                }
                if (currKey == flagKey) {
                    resList.add(currKey + " " + currValue);
                    continue;
                }

                int diff;
                if ((diff = currKey - flagKey - 1) > 0) {
                    for (int i = 1; i <= diff; i++) {
                        resList.add((flagKey + i) + " " + (flagValue + ((currValue- flagValue) / (currKey - flagKey)) * i));
                    }
                }
                resList.add(currKey + " " + currValue);
                flagKey = currKey;
                flagValue = currValue;
            }

            for (String str : resList) {
                System.out.println(str);
            }

        }
    }

}
