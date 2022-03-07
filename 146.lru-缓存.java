import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveHead(node);
            return node.value;
        }
        return -1;
    }
    
    private void addHead(LRUCache.Node node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void moveHead(LRUCache.Node node) {
        removeNode(node);
        addHead(node);
    }

    private void removeNode(LRUCache.Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            addHead(node);
            map.put(key, node);

            if (map.entrySet().size() > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        } else {
            node.value = value;
            moveHead(node);
        }
    }

    class Node {
        int key, value;
        Node prev, next;
        Node () {};
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

