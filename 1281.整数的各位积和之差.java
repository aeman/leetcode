/*
 * @lc app=leetcode.cn id=1281 lang=java
 *
 * [1281] 整数的各位积和之差
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int subtractProductAndSum(int n) {
		List<Integer> list = new ArrayList<>();
		while (n >= 10) {
			int temp = n % 10;
			list.add(temp);
			n = n / 10;
		}
		list.add(n);

		int product = 1, sum = 0;
		for (int i : list) {
			product *= i;
			sum += i;
		}
		return product - sum;
    }
}
// @lc code=end

