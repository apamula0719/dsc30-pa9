/*
 * Name: TODO
 * PID: TODO
 */

import java.util.*;

/**
 * Stack implementation
 *
 * @author Aneesh Pamula
 * @since 6/5/2023
 */

public class DonationStack {

    LinkedList<Integer> stack;

    Stack<Integer> maxStack;

    /**
     * Create a new DonationStack object
     */
    public DonationStack() {
        stack = new LinkedList<>();
        maxStack = new Stack<>();
    }

    /**
     * Push a new donation onto the stack
     * @param val The value of the donation to add
     */
    public void push(int val) {
        stack.add(val);
        if(maxStack.isEmpty() || val > maxStack.peek())
            maxStack.push(val);
    }

    /**
     * Return the top element of the stack without removing
     * @return the top element
     */
    public int peek() {
        return stack.pollLast();
    }

    /**
     * Remove and return the top element of the stack
     * @return the previous top element
     */
    public int pop() {
        System.out.println(maxStack.peek() + " " + stack.peekLast());
        if(maxStack.peek() == stack.peek())
            maxStack.pop();
        System.out.println(this.view());
        return stack.removeLast();
    }

    /**
     * Return the max value of the stack
     * @return the max value of the stack
     */
    public int max() {
        return maxStack.peek();
    }
    public String view(){
        return Arrays.toString(stack.toArray());
    }

    public static void main(String[] args){
        DonationStack stack = new DonationStack();
        stack.push(5);
        stack.push(10);
        stack.push(5);
        stack.push(20);
        stack.push(15);
        System.out.println(stack.view() + "\n");
        System.out.println(stack.max());
        System.out.println(stack.pop() + "\n");
        System.out.println(stack.pop() + "\n");
        System.out.println(stack.max() + "\n");
    }
}