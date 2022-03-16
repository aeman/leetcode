import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
class LFUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity, time = 0;
    private TreeSet<Node> set = new TreeSet<>();
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (capacity == 0) return -1;
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        set.remove(node);
        node.count += 1;
        node.time = time++;
        set.add(node);
        map.put(key, node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (!map.containsKey(key)) {
            if (set.size() == capacity) {
                map.remove(set.first().key);
                set.remove(set.first());
            }
            Node node = new Node(key, value, 1, time++);
            map.put(key, node);
            set.add(node);
        } else {
            Node node = map.get(key);
            set.remove(node);
            node.count += 1;
            node.time = time++;
            node.value = value;
            set.add(node);
            map.put(key, node);
        }
    }

    class Node implements Comparable<Node> {
        int key, value, count, time;
        
        Node () {};
        Node (int key, int value, int count, int time) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(LFUCache.Node o) {
            return count == o.count ? time - o.time : count - o.count;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

