package me.xuling.geek.algorithm;

/**
 * 双端队列，数组实现
 *
 * @author jack
 * @since 2022/1/2
 **/
public class MyCircularDeque {
    int capacity;
    int size = 0;
    int frontIndex = 0;
    int tailIndex = 0;
    int[] deque;

    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
    }

    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        frontIndex -= 1;
        if (frontIndex < 0) {
            frontIndex += capacity;
        }
        deque[frontIndex] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        deque[tailIndex] = value;
        tailIndex = (tailIndex + 1) % capacity;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size <=0) {
            return false;
        }
        frontIndex = (frontIndex + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        tailIndex -= 1;
        if(tailIndex < 0)  {
            tailIndex += capacity;
        }
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return deque[frontIndex];
    }

    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        if(tailIndex == 0) {
            return deque[capacity-1];
        }
        return deque[tailIndex-1];
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }
}
