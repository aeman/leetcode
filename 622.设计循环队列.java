/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    private int front, rear, capacity;
    private int[] elements;

    public MyCircularQueue(int k) {
        this.capacity = k + 1;
        this.elements = new int[capacity];
        front = rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return elements[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return elements[(rear - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

