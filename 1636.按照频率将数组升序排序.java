import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        for (Map.Entry entry : map.entrySet()) {
            queue.add(new int[] {(int) entry.getKey(), (int) entry.getValue()}); 
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            for (int i = 0; i < pair[1]; i++) {
                nums[idx] = pair[0];
                idx++;
            }
        }
        return nums;
    }
}
// @lc code=end

