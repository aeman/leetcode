import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0, left = 0, right = people.length - 1;
        while (left <= right) {
            // 每艘船最多可同时载2人
            if (people[left] + people[right] <= limit) left++;
            right--;
            ans++;
        }
        return ans;
    }
}
// @lc code=end

