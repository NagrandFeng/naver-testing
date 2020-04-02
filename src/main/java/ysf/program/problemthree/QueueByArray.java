package ysf.program.problemthree;


public class QueueByArray<T> {
    private T[] queue;
    private int head = 0;
    private int count = 0;
    private int tail = 0;

    public QueueByArray() {
        queue = (T[]) new Object[16];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public QueueByArray(int size) {
        queue = (T[]) new Object[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    //入队
    public boolean push(T t) {
        if (count == queue.length) {
            return false;
        }
        queue[tail] = t;
        tail++;
        count++;
        return true;
    }

    //出
    public T pop() {
        if (count == 0) {
            return null;
        }
        T t = queue[head];
        head++;
        count--;
        return t;
    }

    //查
    public T peek() {
        if (count == 0) {
            return null;
        }
        return queue[head];
    }

    //清空
    public void empty() {
        count = 0;
        tail =0;
        head = 0;
        queue = (T[]) new Object[16];
    }


}
