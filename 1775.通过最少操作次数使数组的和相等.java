/*
 * @lc app=leetcode.cn id=1775 lang=java
 *
 * [1775] 通过最少操作次数使数组的和相等
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, diff = 0;
        int[] cnt1 = new int[7], cnt2 = new int[7];
        if (6 * n < m || 6 * m < n)
            return -1;

        for (int num : nums1) {
            cnt1[num]++;
            diff += num;
        }
        for (int num : nums2) {
            cnt2[num]++;
            diff -= num;
        }

        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        } else if (diff < 0) {
            return help(cnt1, cnt2, -diff);
        } else {
            return 0;
        }
    }

    private int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }
}
// @lc code=end
