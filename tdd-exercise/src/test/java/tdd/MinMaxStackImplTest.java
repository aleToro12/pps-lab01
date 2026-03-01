package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class MinMaxStackImplTest {
    MinMaxStack minMaxStack;
    
    @BeforeEach
    void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    void testPopThrowsExceptionWhenStackIsEmpty() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            minMaxStack.pop();
        });
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testPopMinMaxWithTwoElementsOnStack() {
        minMaxStack.push(5);
        minMaxStack.push(10);
        assertEquals(5, minMaxStack.getMin());
        assertEquals(10, minMaxStack.getMax());
        assertEquals(10, minMaxStack.pop());
        assertEquals(5, minMaxStack.peek());
    }
}