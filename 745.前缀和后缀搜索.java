import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=745 lang=java
 *
 * [745] 前缀和后缀搜索
 */

// @lc code=start
class WordFilter {
    private Map<String, Integer> dict = new HashMap<>();

    public WordFilter(String[] words) {
        for (int idx = 0; idx < words.length; idx++) {
            String word = words[idx];
            int n = word.length();
            for (int i = 1; i <= n; i++) {
                String prefix = word.substring(0, i);
                for (int j = 1; j <= n; j++) {
                    String suffix = word.substring(n - j);
                    dict.put(prefix + "#" + suffix, idx);
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        return dict.getOrDefault(pref + "#" + suff, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
// @lc code=end

