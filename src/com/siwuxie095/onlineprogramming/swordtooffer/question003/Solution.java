package com.siwuxie095.onlineprogramming.swordtooffer.question003;

import java.util.ArrayList;

/**
 * JZ3 从尾到头打印链表
 *
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个 ArrayList。
 *
 *
 * 示例1
 *
 * 输入
 * {67,0,24,58}
 *
 * 返回值
 * [58,24,0,67]
 *
 * 说明：本题目包含复杂数据结构ListNode，参考：https://blog.nowcoder.net/n/954373f213e14eeab0a69ed0e9ef1b6e
 *
 * @author Jiajing Li
 * @date 2021-03-18 18:59:18
 */
@SuppressWarnings("all")
public class Solution {

    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (null == listNode) {
            return res;
        }
        printListFromTailToHead(listNode.next);
        res.add(listNode.val);
        return res;
    }

}
