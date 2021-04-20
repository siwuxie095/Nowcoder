package com.siwuxie095.onlineprogramming.swordtooffer.question025;

import java.util.HashMap;
import java.util.Map;

/**
 * JZ25 复杂链表的复制
 *
 * 题目描述
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个
 * 特殊指针 random 指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结
 * 点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author Jiajing Li
 * @date 2021-04-20 16:12:11
 */
@SuppressWarnings("all")
public class Solution {

    public RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead) {
            return null;
        }
        RandomListNode curr = pHead;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode newCurr = newHead;
        Map<Integer, RandomListNode> map = new HashMap<>();
        map.put(newHead.label, newHead);
        while (curr.next != null) {
            RandomListNode node = new RandomListNode(curr.next.label);
            map.put(node.label, node);
            newCurr.next = node;
            newCurr = node;
            curr = curr.next;
        }

        curr = pHead;
        newCurr = newHead;
        while (newCurr.next != null) {
            if (curr.random != null) {
                newCurr.random = map.get(curr.random.label);
            }
            newCurr = newCurr.next;
            curr = curr.next;
        }
        return newHead;
    }

}
