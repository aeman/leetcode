import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((a, b) -> {
            int c1 = Integer.bitCount(a), c2 = Integer.bitCount(b);
            return c1 == c2 ? a - b : c1 - c2;
        }).mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
