import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1774 lang=java
 *
 * [1774] 最接近目标价格的甜点成本
 */

// @lc code=start
class Solution {
    private int ans;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ans = Arrays.stream(baseCosts).min().getAsInt();
        for (int base : baseCosts) {
            backtrack(toppingCosts, 0, base, target);
        }
        return ans;
    }

    private void backtrack(int[] toppingCosts, int idx, int cost, int target) {
        if (Math.abs(ans - target) < cost - target) return;
        
        if (Math.abs(ans - target) > Math.abs(cost - target)) {
            ans = cost;
        } else if (Math.abs(ans - target) == Math.abs(cost - target)) {
            ans = Math.min(ans, cost);
        }

        if (idx == toppingCosts.length) return;

        backtrack(toppingCosts, idx + 1, cost + toppingCosts[idx] * 2, target);
        backtrack(toppingCosts, idx + 1, cost + toppingCosts[idx], target);
        backtrack(toppingCosts, idx + 1, cost, target);
    }
}
// @lc code=end

