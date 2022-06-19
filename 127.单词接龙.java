import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord))
            return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int path = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String newWord = new String(arr);
                    if (endWord.equals(newWord))
                        return path + 1;
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, path + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
// @lc code=end
