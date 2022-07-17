/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length, maxLen = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int len = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
// @lc code=end
