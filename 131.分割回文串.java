import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, s, path, list);
        return list;
    }

    private void backtrack(int idx, String s, List<String> path, List<List<String>> list) {
        if (idx == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
                backtrack(i + 1, s, path, list);
                path.remove(path.size() - 1);
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
