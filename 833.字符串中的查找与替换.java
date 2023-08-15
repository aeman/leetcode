/*
 * @lc app=leetcode.cn id=833 lang=java
 *
 * [833] 字符串中的查找与替换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // int n = indices.length;
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {
        //     int len = sources[i].length();
        //     String sub = s.substring(indices[i], indices[i] + len);
        //     if (sub.equals(sources[i])) {
        //         sb.append(targets[i]);
        //     } else {
        //         sb.append(sub);
        //     }
        // }
        // return sb.toString();

        int k = indices.length;
		int[][] idx = new int[k][];
		for (int i = 0; i < k; i++) {
			idx[i] = new int[] { indices[i], i };
		}
		Arrays.sort(idx, (a, b) -> a[0] - b[0]);
		char[] cs = s.toCharArray();
		int last = 0, len = cs.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < k; i++) {
			int[] id = idx[i];
			int start = id[0], src = id[1];
			sb.append(new String(cs, last, start - last));
			last = start;
			int size = sources[src].length();
			String ori = new String(cs, start, Math.min(size, len - start));
			if (ori.equals(sources[src])) {
				sb.append(targets[src]);
				last = start + size;
			}
		}
		sb.append(new String(cs, last, cs.length - last));
		return sb.toString();
    }
}
// @lc code=end

