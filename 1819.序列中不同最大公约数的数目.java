import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1819 lang=java
 *
 * [1819] 序列中不同最大公约数的数目
 */

// @lc code=start
class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] occured = new boolean[maxVal + 1];
        for (int num : nums) {
            occured[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= maxVal; i++) {
            int subGcd = 0;
            for (int j = i; j <= maxVal; j += i) {
                if (occured[j]) {
                    if (subGcd == 0) {
                        subGcd = j;
                    } else {
                        subGcd = gcd(subGcd, j);
                    }
                    if (subGcd == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
// @lc code=end

