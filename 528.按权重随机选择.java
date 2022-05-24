import java.util.Random;

/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
class Solution {
    private int total;
    private int[] sums;

    public Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < sums.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        int r = random.nextInt(total);

        int left = 0, right = sums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] > r) {
                if (mid == 0 || sums[mid - 1] <= r) return mid;
                right = mid  - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

