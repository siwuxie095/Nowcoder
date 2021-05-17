package com.siwuxie095.onlineprogramming.swordtooffer.question058;

/**
 * JZ58 对称的二叉树
 *
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 *
 * 示例1
 *
 * 输入
 * {8,6,6,5,7,7,5}
 *
 * 返回值
 * true
 *
 *
 * 示例2
 *
 * 输入
 * {8,6,9,5,7,7,5}
 *
 * 返回值
 * false
 *
 * @author Jiajing Li
 * @date 2021-05-17 17:37:10
 */
@SuppressWarnings("all")
public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        return judge(pRoot, pRoot);
    }

    private boolean judge(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left && null != right || null != left && null == right) {
            return false;
        }
        return left.val == right.val && judge(left.left, right.right) && judge(left.right, right.left);
    }

}
