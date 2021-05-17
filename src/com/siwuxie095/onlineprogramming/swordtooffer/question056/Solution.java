package com.siwuxie095.onlineprogramming.swordtooffer.question056;

/**
 * JZ56 删除链表中重复的结点
 *
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表 1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 示例1
 *
 * 输入
 * {1,2,3,3,4,4,5}
 *
 * 返回值
 * {1,2,5}
 *
 * @author Jiajing Li
 * @date 2021-05-17 13:53:28
 */
@SuppressWarnings("all")
public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode curr = pHead;
        ListNode start = null;
        ListNode end = null;
        while (null != curr) {
            if (null != curr.next && curr.val == curr.next.val) {
                if (null == start) {
                    start = curr;
                    end = curr.next;
                } else {
                    end = curr.next;
                }
                curr = curr.next;
            } else {
                if (null != start && null != end) {
                    pre.next = curr.next;
                    curr = curr.next;
                    start = null;
                    end = null;
                } else {
                    curr = curr.next;
                    pre = pre.next;
                }
            }

        }
        return dummy.next;
    }

}
