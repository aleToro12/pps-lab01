package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class SmartDoorLockTest {
    SmartDoorLock smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoorLockImpl();
        smartDoor.setPin(1234);
        smartDoor.lock();
    }

    @Test
    void testInitialState() {
        assertTrue(smartDoor.isLocked());
        assertFalse(smartDoor.isBlocked());
        assertEquals(0, smartDoor.getFailedAttempts());
    }

    @Test
    void setPinAndUnlockTest() {
        smartDoor.unlock(1234);
        assertFalse(smartDoor.isLocked());
        assertFalse(smartDoor.isBlocked());
        assertEquals(0, smartDoor.getFailedAttempts());
    }

    @Test
    void unlockWithFailedAttemptTest() {
        smartDoor.unlock(1235);
        assertTrue(smartDoor.isLocked());
        assertFalse(smartDoor.isBlocked());
        assertEquals(1, smartDoor.getFailedAttempts());
    }

    @Test
    void blockTest() {
        smartDoor.unlock(1235);
        smartDoor.unlock(1236);
        smartDoor.unlock(1237);
        assertTrue(smartDoor.isLocked());
        assertTrue(smartDoor.isBlocked());
        assertEquals(3, smartDoor.getFailedAttempts());
    }
}
