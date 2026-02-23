package example.model;

public class SimpleBankAccountWithFee extends SimpleBankAccount{

    private final static int WITHDRAWAL_FEE = 1;

    public SimpleBankAccountWithFee(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        super.withdraw(userID, amount +  WITHDRAWAL_FEE);
    }

    @Override
    protected boolean isWithdrawAllowed(final double amount) {
        return super.isWithdrawAllowed(amount +  WITHDRAWAL_FEE);
    }
}
