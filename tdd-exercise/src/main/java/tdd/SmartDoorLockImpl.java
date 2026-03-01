package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {
    private boolean locked;
    private boolean blocked;
    private int attempts;
    private int pin;
    private final static int MAX_ATTEMPTS = 3;


    public SmartDoorLockImpl() {
        setInitialState();
    }

    @Override
    public void setPin(int pin) {
        if(!isBlocked() || !isLocked()) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(isLocked() && !isBlocked()) {
            if(this.pin == pin) {
                this.locked = false;
                this.attempts = 0;
            } else {
                this.blocked = ++this.attempts >= MAX_ATTEMPTS;
            }
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
        setInitialState();
    }

    private void setInitialState() {
        this.locked = false;
        this.blocked = false;
        this.pin = -1;
        this.attempts = 0;
    }
}
