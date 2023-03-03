import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1487 lang=java
 *
 * [1487] 保证文件名唯一
 */

// @lc code=start
class Solution {
    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 1);
                ans[i] = name;
            } else {
                int version = map.get(name);
                String newName = name + "(" + version + ")";
                while (map.containsKey(newName)) {
                    version++;
                    newName = name + "(" + version + ")";
                }
                map.put(newName, 1);
                map.put(name, version + 1);
                ans[i] = newName;
            }
        }
        return ans;
    }
}
// @lc code=end

