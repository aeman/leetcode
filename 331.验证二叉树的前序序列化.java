import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);

        for (String s : preorder.split(",")) {
            if (stack.isEmpty()) return false;

            int top = stack.pop() - 1;
            // 还有其他节点，重新push
            if (top > 0) stack.push(top);

            // 如果是数字，下面新增两个槽位
            if (!s.equals("#")) {
                stack.push(2);
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

