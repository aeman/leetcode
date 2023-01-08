import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2042 lang=java
 *
 * [2042] 检查句子中的数字是否递增
 */

// @lc code=start
class Solution {
    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String s1 : arr) {
            if (Character.isDigit(s1.charAt(0))) {
                list.add(Integer.valueOf(s1));
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }
}
// @lc code=end

