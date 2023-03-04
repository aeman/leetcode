import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1487 lang=java
 *
 * [1487] 保证文件名唯一
 */

// @lc code=start
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                int version = map.get(name);
                String newName = name + "(" + version + ")";
                while (map.containsKey(newName)) {
                    version++;
                    newName = name + "(" + version + ")";
                }
                map.put(newName, 1);
                map.put(name, version + 1);
            }
        }
        return map.keySet().toArray(new String[0]);
    }
}
// @lc code=end

