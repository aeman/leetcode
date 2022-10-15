import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1441 lang=java
 *
 * [1441] 用栈操作构建数组
 */

// @lc code=start
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int prev = 0;

        for (int num : target) {
            for (int i = 0; i < num - prev - 1; i++) {
                list.add("Push");
                list.add("Pop");
            }
            list.add("Push");
            prev = num;
        }

        return list;
    }
}
// @lc code=end

