import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private List<String> sublist = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s);
        return ans;
    }

    private void backtrack(int index, String s) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(sublist));
            return;
        }

        for (int j = index; j < s.length(); j++) {
            if (isPalindrome(s, index, j)) {
                sublist.add(s.substring(index, j + 1));
                backtrack(j + 1, s);
                sublist.remove(sublist.size() - 1);
            }
        }
    }

    // 判断是否回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end
