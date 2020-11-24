package com.my.blog.website.dataStructure;

public class ArrayQueueDemo {

    public static void main(String[] args) {

    }
}

class ArrayQueue{
    private int maxSize; //数组最大容量

    private int front; //头指针

    private int rear; //队列尾

    private int[] arr; //存放数据，模拟队列

    //构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr  =  new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满!");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的。。。");
            return;
        }
        for(int i = 0; i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队头数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列空。。");
        }
        return arr[front+1];
    }





}
