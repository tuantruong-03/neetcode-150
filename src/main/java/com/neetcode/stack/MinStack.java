package com.neetcode.stack;

import java.util.Stack;


public class MinStack {
}

// By myself
class MinStack1 {
    private Stack<Integer> internalStack;
    private Stack<Integer> minStack;
    public MinStack1() {
        internalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        internalStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }
        int lastMin = minStack.peek();
        if (val <= lastMin) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (internalStack.isEmpty()) {
            return;
        }
        int pop = internalStack.pop();
        if (!minStack.isEmpty() && pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return internalStack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) return minStack.peek();
        return internalStack.peek();
    }
}

// By other
class MinStack2 {
    class Node {
        int val;
        int min;
        Node previous;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.previous = null;
        }
    }
    Node top;
    public MinStack2() {

    }

    public void push(int val) {
        Node tempTop = new Node(val, val);
        if (top == null) {
            top = tempTop;
            return;
        }
        tempTop.min = Math.min(val, top.min);
        tempTop.previous = top;
        top = tempTop;
    }

    public void pop() {
        if (top == null) return;
        top = top.previous;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}

class MinStackPractice {
    private Stack<Integer> internalStack;
    private Stack<Integer> minStack;
    public MinStackPractice() {
        internalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        internalStack.push(val);
        if (!minStack.isEmpty()) {
            int peek = minStack.peek();
            if (val <= peek) {
                minStack.push(val);
            }
            return;
        }
        minStack.push(val);
    }

    public void pop() {
        int pop = internalStack.pop();
        if (!minStack.isEmpty()) {
            int peek = minStack.peek();
            if (pop == peek) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return internalStack.peek();
    }

    public int getMin() {
        return !minStack.isEmpty() ? minStack.peek() : -1;
    }

    public static void main(String[] args) {
        MinStackPractice practice = new MinStackPractice();
        practice.push(-2);
        practice.push(-0);
        practice.push(-1);
        practice.getMin();
        practice.top();
        practice.pop();
    }
}