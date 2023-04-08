import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1125 lang=java
 *
 * [1125] 最小的必要团队
 */

// @lc code=start
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int m = people.size();
        int n = req_skills.length;
        Map<String, Integer> skillToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillToId.put(req_skills[i], i);
        }
        int[] peopleSkills = new int[m];
        for (int i = 0; i < m; i++) {
            int skill = 0;
            for (String s : people.get(i)) {
                skill |= (1 << skillToId.get(s));
            }
            peopleSkills[i] = skill;
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int[][] pre = new int[1 << n][2];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(pre[i], -1);
        }
        for (int i = 0; i < m; i++) {
            int skill = peopleSkills[i];
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if (dp[j] == -1) {
                    continue;
                }
                int nxt = j | skill;
                if (dp[nxt] == -1 || dp[nxt] > dp[j] + 1) {
                    dp[nxt] = dp[j] + 1;
                    pre[nxt][0] = j;
                    pre[nxt][1] = i;
                }
            }
        }
        int[] team = new int[dp[(1 << n) - 1]];
        int cnt = 0;
        int cur = (1 << n) - 1;
        while (pre[cur][0] != -1) {
            team[cnt++] = pre[cur][1];
            cur = pre[cur][0];
        }
        return team;
    }
}
// @lc code=end

