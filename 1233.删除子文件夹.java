import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1233 lang=java
 *
 * [1233] 删除子文件夹
 */

// @lc code=start
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String pre = ans.get(ans.size() - 1);
            int len = pre.length();
            if (len < folder[i].length() 
                && pre.equals(folder[i].substring(0, len)) 
                && folder[i].charAt(len) == '/') {
                continue;
            }
            ans.add(folder[i]);
        }
        return ans;
    }
}
// @lc code=end

