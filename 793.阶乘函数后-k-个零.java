/*
 * @lc app=leetcode.cn id=793 lang=java
 *
 * [793] 阶乘函数后 K 个零
 */

// @lc code=start
class Solution {
    public int preimageSizeFZF(int k) {
        int zeroInMid = 0, low = 0, high = (int) Math.pow(10, 9);

        while (low < high) {
            int mid = (low + high) / 2;
            zeroInMid = trailZero(mid);

            if (zeroInMid < k) {
                low = mid + 1;
            } else if (zeroInMid > k) {
                high = mid;
            } else {
                return 5;
            }
        }

        return 0;
    }

    private int trailZero(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i = i * 5) {
            ans += n / i;
        }
        return ans;
    }
}
// @lc code=end
