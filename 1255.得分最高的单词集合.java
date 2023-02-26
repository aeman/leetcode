/*
 * @lc app=leetcode.cn id=1255 lang=java
 *
 * [1255] 得分最高的单词集合
 */

// @lc code=start
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return backtrack(words, count, score, 0, 0);
    }

    private int backtrack(String[] words, int[] count, int[] score, int index, int curScore) {
        int maxScore = curScore;
        for (int i = index; i < words.length; i++) {
            int[] newCount = count.clone();
            boolean isValid = true;
            int wordScore = 0;
            for (char c : words[i].toCharArray()) {
                int pos = c - 'a';
                newCount[pos]--;
                if (newCount[pos] < 0) {
                    isValid = false;
                    break;
                }
                wordScore += score[pos];
            }
            if (isValid) {
                int scoreWithWord = backtrack(words, newCount, score, i + 1, curScore + wordScore);
                maxScore = Math.max(maxScore, scoreWithWord);
            }
        }
        return maxScore;
    }
}
// @lc code=end
