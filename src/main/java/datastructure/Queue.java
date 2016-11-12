package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by leibnik on 16-10-23.
 */
public class Queue {
    public int tail;
    public int head;
    public int[] q;

    public Queue(int size){
        q = new int[size];
        tail = 0;
        head = 0;
    }
    public void enqueue(int x){
        if (isFull()){
            System.out.println("上溢");
            return;
        }
        q[tail] = x;
        if (tail == q.length - 1){
            tail = 0;
        }else {
            tail += 1;
        }
        System.out.println(Arrays.toString(q));
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("下溢");
            return -1;
        }
        int x = q[head];
        if (head == q.length - 1){
            head = 0;
        }else{
            head += 1;
        }
        System.out.println(Arrays.toString(q));
        System.out.println(x);
        return x;
    }

    private boolean isFull(){
        if ((tail == q.length - 1 && head == 0 )|| head == tail + 1){
            return true;
        }
        return false;
    }

    private boolean isEmpty(){
        if (head == tail){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(14);
        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.enqueue(18);

        q.dequeue();
        q.dequeue();

        q.enqueue(19);
        q.enqueue(20);
        q.enqueue(21);
        q.enqueue(22);

    }

}
