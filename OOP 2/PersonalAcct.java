public class PersonalAcct extends Account {

    public PersonalAcct (Customer customer, double balance, int passwordHashCode) {
        super(customer, balance, passwordHashCode);
    }

    @Override
    /**
     * Withdraws the given amount from the account.
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            if (getBalance()-amount < 100.0) {
                System.out.println("Personal accounts require a minimum balanace of $100, a service charge of $2.00 has been deducted from your account.");
                return super.withdraw(amount + 2.0);
            }
            return super.withdraw(amount);
        }
        return false;
    }

}
