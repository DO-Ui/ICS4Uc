public class Account {
    private double balance;
    private Customer customer;
    private int passwordHashCode;


    /**
     * @brief This is the constructor for the Account class.
     * @param customer The customer object.
     * @param balance The balance of the account.
     */
    public Account(Customer customer, double balance, int passwordHashCode) {
        this.customer = customer;
        this.balance = balance;
        this.passwordHashCode = passwordHashCode;
    }


    /**
     * @brief This is the getter for the balance of the account.
     * @return The balance of the account.
     */
    public double getBalance() {
        return balance;
    }


    /**
     * @brief This is the getter for the customer object.
     * @param amount The amount to deposit.
     * @return True if the deposit was successful, false otherwise.
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    /**
     * @brief This is the getter for the customer object.
     * @param amount The amount to withdraw.
     * @return True if the withdrawal was successful, false otherwise.
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * @brief This is the getter for the account data
     * @return The account data as a string.
     */
    public String toString() {
        return customer.toString() + "\n" + "Balance: " + balance;
    }

    /**
     * @brief This is the getter for the customer object.
     * @return The customer object.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @brief This is the getter for the password hash code.
     * @return The password hash code.
     */
    public int getPasswordHashCode() {
        return passwordHashCode;
    }

}


