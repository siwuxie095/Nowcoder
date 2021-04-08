package com.siwuxie095.onlineprogramming.swordtooffer.question015;

/**
 * JZ15 反转链表
 *
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 *
 * 示例1
 *
 * 输入
 * {1,2,3}
 *
 * 返回值
 * {3,2,1}
 *
 * 说明：本题目包含复杂数据结构ListNode，参考：https://blog.nowcoder.net/n/954373f213e14eeab0a69ed0e9ef1b6e
 *
 * @author Jiajing Li
 * @date 2021-04-08 16:09:47
 */
@SuppressWarnings("all")
public class Solution {

    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        curr.next = null;
        while (null != next) {
            head = next;
            ListNode nextNext = next.next;
            next.next = curr;
            curr = next;
            next = nextNext;
        }
        return head;
    }

}
