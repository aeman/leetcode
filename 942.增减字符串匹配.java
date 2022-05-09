import java.lang.reflect.AnnotatedArrayType;

/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length() + 1];
        int index = 0, left = 0, right = s.length();
        for (char c : s.toCharArray()) {
            if (c == 'I') {
                ans[index] = left;
                left++;
            } else if (c == 'D') {
                ans[index] = right;
                right--;
            }
            index++;
        }
        ans[index] = left++;
        return ans;
    }
}
// @lc code=end
