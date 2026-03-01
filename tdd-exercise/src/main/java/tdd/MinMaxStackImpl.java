package tdd;

import java.util.ArrayList;

public class MinMaxStackImpl implements MinMaxStack {
    private ArrayList<Integer> stack;

    public MinMaxStackImpl() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(getLastIndex());
    }

    @Override
    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(getLastIndex());
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private int getLastIndex() {
        return stack.size() - 1;
    }
}
