/*
 * @lc app=leetcode.cn id=2024 lang=java
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxCount(answerKey, k, 'T'), maxCount(answerKey, k, 'F'));
    }

    private int maxCount(String answerKey, int k, char c) {
        int left = 0, right = 0, count = 0, sum = 0;

        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) != c) {
                sum++;
            }
            while (sum > k) {
                if (answerKey.charAt(left) != c) {
                    sum--;
                }
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }

        return count;
    }
}
// @lc code=end

