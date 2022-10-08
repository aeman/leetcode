import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.sort(nums1);

        // 排序并记录num2元素的原始位置
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] { i, nums2[i] });
        }

        int left = 0, right = n - 1;
        while (!queue.isEmpty()) {
            int[] n2 = queue.poll();
            // 先用最强马比较，比不过就用最弱的马去送
            if (nums1[right] > n2[1]) {
                ans[n2[0]] = nums1[right];
                right--;
            } else {
                ans[n2[0]] = nums1[left];
                left++;
            }
        }

        return ans;
    }
}
// @lc code=end
