package bankproduct;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BankProduct {

    protected String currency;
    protected double balance;
    protected String name;

    public BankProduct(String currency, double balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name + "-" + this.getClass().getSimpleName();
    }

    public double getBalance() {
        log.info("Your balance is : {}", balance);
        return balance;
    }

    public void replenishBalance(double amount) {
        if (amount >= 0) {
            balance += amount;
            log.info("Your balance is : {}", balance);
        }
    }
}
