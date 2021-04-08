package com.siwuxie095.onlineprogramming.swordtooffer.question016;

/**
 * JZ16 合并两个排序的链表
 *
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 *
 * 示例1
 *
 * 输入
 * {1,3,5},{2,4,6}
 *
 * 返回值
 * {1,2,3,4,5,6}
 *
 * 说明：本题目包含复杂数据结构ListNode，参考：https://blog.nowcoder.net/n/954373f213e14eeab0a69ed0e9ef1b6e
 *
 * @author Jiajing Li
 * @date 2021-04-08 17:46:17
 */
@SuppressWarnings("all")
public class Solution {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (true) {
            if (null == list1 && null == list2) {
                break;
            }
            if (null != list1 && null != list2) {
                if (list1.val <= list2.val) {
                    curr.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    curr.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            } else if (null != list1) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
