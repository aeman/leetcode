import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = expression.substring(0, i), part2 = expression.substring(i + 1);
                List<Integer> part1List = diffWaysToCompute(part1), part2List = diffWaysToCompute(part2);

                for (Integer i1 : part1List) {
                    for (Integer i2 : part2List) {
                        int ret = 0;
                        switch (expression.charAt(i)) {
                            case '+': ret = i1 + i2; break;
                            case '-': ret = i1 - i2; break;
                            case '*': ret = i1 * i2; break;
                        }
                        list.add(ret);
                    }
                }
            }
        }

        if (list.size() == 0) {
            list.add(Integer.parseInt(expression));
        }
        return list;
    }
}
// @lc code=end

