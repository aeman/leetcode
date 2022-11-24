import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
    public String customSortString(String order, String s) {
        int[] letters = new int[26];
        for (int i = 0; i < order.length(); i++) {
            letters[order.charAt(i) - 'a'] = i + 1;
        }

        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, Comparator.comparingInt(x -> letters[x - 'a']));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

