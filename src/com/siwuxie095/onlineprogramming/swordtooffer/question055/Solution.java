package com.siwuxie095.onlineprogramming.swordtooffer.question055;

/**
 * JZ55 链表中环的入口结点
 *
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出 null。
 *
 * @author Jiajing Li
 * @date 2021-05-17 10:28:30
 */
@SuppressWarnings("all")
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(null == pHead || null == pHead.next){
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = pHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }

}
