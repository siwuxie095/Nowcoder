package com.siwuxie095.onlineprogramming.swordtooffer.question036;

/**
 * JZ36 两个链表的第一个公共结点
 *
 * 题目描述
 * 输入两个无环的单链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的
 * 提示是用其他方式显示的，保证传入数据是正确的）
 *
 * @author Jiajing Li
 * @date 2021-05-07 19:34:49
 */
@SuppressWarnings("all")
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(null == pHead1 || null == pHead2) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

}
