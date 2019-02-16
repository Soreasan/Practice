/*
Basic implementation of a stack.
Taken from Cracking the Coding interview.  
*/
import java.util.*;

public class Stack{
    
    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
    }

    private Node top;

    public int pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        int output = top.data;
        top = top.next;
        return output;
    }

    public void push(int item){
        Node node = new Node(item);
        node.next = top;
        top = node;
    }

    public int peek(){
        if(top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String args[]){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(5);
        stack.peek();
        stack.isEmpty();
        stack.pop();
    }
}
