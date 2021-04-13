package com.siwuxie095.onlineprogramming.swordtooffer.question021;

import java.util.Stack;

/**
 * JZ21 栈的压入、弹出序列
 *
 * 题目描述
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该
 * 压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,4,5],[4,3,5,1,2]
 *
 * 返回值
 * false
 *
 * @author Jiajing Li
 * @date 2021-04-13 15:23:35
 */
@SuppressWarnings("all")
public class Solution {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int pop : popA) {
            if (stack.isEmpty() || pop != stack.peek()) {
                for (; i < pushA.length; i++) {
                    int push = pushA[i];
                    if (pop != push) {
                        stack.push(push);
                    } else {
                        i++;
                        break;
                    }
                }
            } else if (pop == stack.peek()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
