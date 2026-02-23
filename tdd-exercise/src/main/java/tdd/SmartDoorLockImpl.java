package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {
    private boolean locked;
    private boolean blocked;
    private int attempts = 0;
    private int pin;
    private final static int MAX_ATTEMPTS = 3;


    @Override
    public void setPin(int pin) {
        if(!isBlocked() || !isLocked()) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(isLocked() && !isBlocked()) {
            this.locked = this.pin != pin;
        }
    }

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.attempts;
    }

    @Override
    public void reset() {
        attempts = 0;
        pin = 0;
        locked = false;
        blocked = false;
    }
}
