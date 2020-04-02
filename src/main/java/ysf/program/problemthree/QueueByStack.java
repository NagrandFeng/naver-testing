package ysf.program.problemthree;

import java.util.Stack;

public class QueueByStack<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public QueueByStack() {
    }

    //入
    public boolean push(T t) {
        stack1.push(t);
        return true;
    }

    //出
    public T pop() {
       if(stack2.size() <= 0){
           while (stack1.size()>0){
               T headData = stack1.pop();
               stack2.push(headData);
           }
       }
       if(stack2.size() == 0){
           System.out.println("队列为空");
           throw new RuntimeException("队列为空");
       }
       T headData = stack2.pop();
       return headData;
    }

    //查
    public T peek() {
        if(stack2.size() <= 0){
            while (stack1.size()>0){
                T headData = stack1.pop();
                stack2.push(headData);
            }
        }
        if(stack2.size() == 0){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }

        T headData = stack2.peek();
        return headData;
    }

    //清空
    public void empty() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

}
