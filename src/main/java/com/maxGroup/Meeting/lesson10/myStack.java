package com.maxGroup.Meeting.lesson10;

public class myStack implements intStack {
    private int size;
    private int[] array;
    private int top;

    public myStack(int size){
        this.size = size;
        array = new int[size];
        top = -1;
    }
    public void push(int item){
        array[++top]=item;
    }
    public int pop(){
        return array[top--];
    }
    public int top(){
        return array[top];
    }
    public boolean isEmpty(){
        return (top<0);
    }
    public boolean isFull(){
        return (top>=size-1);
    }
}
