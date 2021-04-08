package com.siwuxie095.onlineprogramming.swordtooffer.question014;

/**
 * JZ14 链表中倒数第 K 个节点
 *
 * 题目描述
 *
 * 输入一个链表，输出该链表中倒数第 k 个结点。
 * 如果该链表长度小于 k，请返回空。
 *
 *
 * 示例1
 *
 * 输入
 * {1,2,3,4,5},1
 *
 * 返回值
 * {5}
 *
 * 说明：本题目包含复杂数据结构ListNode，参考：https://blog.nowcoder.net/n/954373f213e14eeab0a69ed0e9ef1b6e
 *
 * @author Jiajing Li
 * @date 2021-04-08 13:31:00
 */
@SuppressWarnings("all")
public class Solution {

    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (null == pHead) {
            return null;
        }

        ListNode first = pHead;
        ListNode second = null;
        ListNode curr = pHead;
        int count = 0;
        while (null != curr) {
            count++;
            if (count == k) {
                second = curr;
                break;
            } else {
                curr = curr.next;
            }
        }

        if (null == second) {
            return null;
        }

        while (null != second) {
            second = second.next;
            if (null == second) {
                return first;
            } else {
                first = first.next;
            }
        }
        return null;
    }

}
