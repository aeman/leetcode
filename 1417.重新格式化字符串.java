import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1417 lang=java
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution {
    public String reformat(String s) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                list1.add(c);
            } else {
                list2.add(c);
            }
        }

        int len1 = list1.size(), len2 = list2.size();
        if (Math.abs(len1 - len2) > 1) return "";

        if (len1 >= len2) {
            return mix(list1, list2);
        } else {
            return mix(list2, list1);
        }
    }

    private String mix(List<Character> list1, List<Character> list2) {
        int n1 = list1.size(), n2 = list2.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            sb.append(list1.get(i));
            sb.append(list2.get(i));
        }
        if (n1 > n2) sb.append(list1.get(list1.size() - 1));
        return sb.toString();
    }
}
// @lc code=end
