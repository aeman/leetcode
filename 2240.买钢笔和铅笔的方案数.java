/*
 * @lc app=leetcode.cn id=2240 lang=java
 *
 * [2240] 买钢笔和铅笔的方案数
 */

// @lc code=start
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) return waysToBuyPensPencils(total, cost2, cost1);

        long ans = 0, cnt = 0;
        while (cost1 * cnt <= total) {
            ans += (total - cost1 * cnt) / cost2 + 1;
            cnt++;
        }
        return ans;
    }
}
// @lc code=end

