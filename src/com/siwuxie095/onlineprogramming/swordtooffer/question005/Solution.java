package com.siwuxie095.onlineprogramming.swordtooffer.question005;

import java.util.Stack;

/**
 * JZ5 用两个栈实现队列
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。队列中的元素为 int 类型。
 *
 * @author Jiajing Li
 * @date 2021-03-30 19:49:05
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return pop();
        } else {
            return stack2.pop();
        }
    }

}
