import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    begin++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
