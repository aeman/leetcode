import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] domainAndTimes = cpdomain.split(" ");
            int times = Integer.parseInt(domainAndTimes[0]);
            String domain = domainAndTimes[1];
            map.put(domain, map.getOrDefault(domain, 0) + times);

            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String part = domain.substring(i + 1, domain.length());
                    map.put(part, map.getOrDefault(part, 0) + times);
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(map.get(key) + " " + key);
        }
        return list;
    }
}
// @lc code=end

