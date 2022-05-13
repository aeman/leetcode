import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ans = 0;
        
        //不使用大礼包
        for (int i = 0; i < needs.size(); i++) {
            ans += needs.get(i) * price.get(i);
        }

        // 使用大礼包
        for (List<Integer> s : special) {
            List<Integer> cur = new ArrayList<>(needs);
            boolean flag = false;
            for (int i = 0; i < needs.size(); i++) {
                if (cur.get(i) < s.get(i)) {
                    flag = true;
                    break;
                }
                cur.set(i, cur.get(i) - s.get(i));
            }

            if (!flag) {
                ans = Math.min(ans, s.get(needs.size()) + dfs(price, special, cur));
            }
        }

        return ans;
    }
}
// @lc code=end

