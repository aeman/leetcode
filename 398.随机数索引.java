import java.util.Random;

/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {
    private Random random;
    private int[] nums;

    public Solution(int[] nums) {
        this.random = new Random();
        this.nums = nums;
    }
    
    public int pick(int target) {
        int n = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                n++;
                if (random.nextInt(n) == 0) index = i;
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

