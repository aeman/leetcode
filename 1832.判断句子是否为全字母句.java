/*
 * @lc app=leetcode.cn id=1832 lang=java
 *
 * [1832] 判断句子是否为全字母句
 */

// @lc code=start
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (char c : sentence.toCharArray()) {
            arr[c - 'a'] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) return false;
        }
        return true;
    }
}
// @lc code=end

