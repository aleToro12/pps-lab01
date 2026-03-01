package tdd;

import java.util.ArrayList;

public class MinMaxStackImpl implements MinMaxStack {
    private ArrayList<Integer> stack;
    private int min;
    private int max;

    public MinMaxStackImpl() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stack.add(value);
        min = stack.isEmpty() ? value : Math.min(min, value);
        max = stack.isEmpty() ? value : Math.max(max, value);
    }

    @Override
    public int pop() {
        ensureNotEmpty();
        return stack.remove(getLastIndex());
    }

    @Override
    public int peek() {
        ensureNotEmpty();
        return stack.get(getLastIndex());
    }

    @Override
    public int getMin() {
        ensureNotEmpty();
        return this.min;
    }

    @Override
    public int getMax() {
        ensureNotEmpty();
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    private int getLastIndex() {
        return stack.size() - 1;
    }

    private void ensureNotEmpty() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }
}
