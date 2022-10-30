import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    private void dfs(char[] arr, int pos, List<String> list) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            list.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos + 1, list);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, list);
    }
}
// @lc code=end

