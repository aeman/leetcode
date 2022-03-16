import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=432 lang=java
 *
 * [432] 全 O(1) 的数据结构
 */

// @lc code=start
class AllOne {
    Node head = new Node("", 0);
    Map<String, Node> map = new HashMap<>();
    
    public AllOne() {
        head.prev = head;
        head.next = head;
    }
    
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key), nxt = cur.next;
            if (nxt == head || nxt.count > cur.count + 1) {
                map.put(key, cur.insert(new Node(key, cur.count + 1)));
            } else {
                nxt.keys.add(key);
                map.put(key, nxt);
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                cur.remove();
            }
        } else {
            if (head.next == head || head.next.count > 1) {
                map.put(key, head.insert(new Node(key, 1)));
            } else {
                head.next.keys.add(key);
                map.put(key, head.next);    
            }
        }
    }
    
    public void dec(String key) {
        Node cur = map.get(key);
        if (cur.count == 1) {
            map.remove(key);
        } else {
            Node pre = cur.prev;
            if (pre == head || pre.count < cur.count - 1) {
                map.put(key, cur.prev.insert(new Node(key, cur.count - 1)));
            } else {
                pre.keys.add(key);
                map.put(key, pre);
            }
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()) {
            cur.remove();
        }
    }
    
    public String getMaxKey() {
        return head.prev != null ? head.prev.keys.iterator().next() : "";
    }
    
    public String getMinKey() {
        return head.next != null ? head.next.keys.iterator().next() : "";
    }

    class Node {
        Node prev;
        Node next;
        Set<String> keys;
        int count;

        public Node(String key, int count) {
            this.count = count;
            this.keys = new HashSet<>();
            keys.add(key);
        }

        public Node insert(Node node) {
            node.prev = this;
            node.next = this.next;
            this.next.prev = node;
            this.next = node;
            return node;
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

