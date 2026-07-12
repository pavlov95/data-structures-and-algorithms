package stack.leetcodeSolutions;

import java.util.ArrayDeque;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

//Implement the MinStack class:

//MinStack() initializes the stack object.
//void push(int value) pushes the element value onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.

//Constraints:
//
//-231 <= val <= 231 - 1
//Methods pop, top and getMin operations will always be called on non-empty stacks.
//At most 3 * 104 calls will be made to push, pop, top, and getMin.

class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;


    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int value) {

        stack.push(value);
        if(minStack.isEmpty() || value<= minStack.peek()){
            minStack.push(value);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if(minStack.peek()== popped){
            minStack.pop();
        }
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
