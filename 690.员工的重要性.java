import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return bfs(id);
        // return dfs(id);
    }

    private int bfs(int id) {
        int total = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer curId = queue.poll();
                for (Integer childId : map.get(curId).subordinates) {
                    queue.offer(childId);
                }
                total += map.get(curId).importance;
                size--;
            }
        }
        return total;
    }

    private int dfs(Integer id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        for (Integer childId : employee.subordinates) {
            total += dfs(childId);
        }
        return total;
    }
}
// @lc code=end

