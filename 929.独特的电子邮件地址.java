import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=929 lang=java
 *
 * [929] 独特的电子邮件地址
 */

// @lc code=start
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int at = email.indexOf("@");
            String local = email.substring(0, at).split("\\+")[0];
            local = local.replace(".", "");
            set.add(local + email.substring(at));
        }
        return set.size();
    }
}
// @lc code=end

