import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1656 lang=java
 *
 * [1656] 设计有序流
 */

// @lc code=start
class OrderedStream {
    private String[] elements;
    private int index;

    public OrderedStream(int n) {
        elements = new String[n + 1];
        index = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        elements[idKey] = value;
        List<String> ans = new ArrayList<>();
        while (index < elements.length && elements[index] != null) {
            ans.add(elements[index]);
            index++;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end

