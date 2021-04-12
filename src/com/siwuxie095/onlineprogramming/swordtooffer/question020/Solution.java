package com.siwuxie095.onlineprogramming.swordtooffer.question020;

import java.util.Stack;

/**
 * JZ20 包含 min 函数的栈
 *
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数
 * （时间复杂度应为 O(1)）。
 *
 * PS：每次入栈，都更新一次当前栈中元素的最小值。
 *
 * @author Jiajing Li
 * @date 2021-04-12 13:25:38
 */
@SuppressWarnings("all")
public class Solution {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        if (stack.isEmpty() || node < min()) {
            min.push(node);
        } else {
            min.push(min());
        }
        stack.push(node);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

}
