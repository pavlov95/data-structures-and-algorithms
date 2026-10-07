package queue.leetcodeSoludtions;

import java.util.ArrayDeque;
//232. Implement Queue using Stacks

//Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
//functions of a normal queue (push, peek, pop, and empty).

//Implement the MyQueue class:

//void push(int x) Pushes element x to the back of the queue.

//int pop() Removes the element from the front of the queue and returns it.
//int peek() Returns the element at the front of the queue.
//boolean empty() Returns true if the queue is empty, false otherwise.
public class ImplementQueueUsingStacks {
    static class MyQueue {
        private final ArrayDeque<Integer> inputStack;
        private final ArrayDeque<Integer> outputStack;

        public MyQueue() {
            inputStack = new ArrayDeque<>();
            outputStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            moveElements();
            return outputStack.pop();
        }

        public int peek() {
            moveElements();
            return outputStack.peek();
        }

        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }

        private void moveElements() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
        }
    }
}