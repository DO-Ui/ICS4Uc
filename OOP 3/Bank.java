/**
 * @file Bank.java
 * @brief This Java file describes the Bank interface used in OOP3, extended in PiggyBank.
 */

 /**
  * This interface is used to represent a bank
  */
public interface Bank {
    
    public double getBalance();

    public boolean addCoins(Coins coinType, int numCoins);

    public boolean subCoins(Coins coinType, int numCoins);
    
}
