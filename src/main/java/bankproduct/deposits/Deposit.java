package bankproduct.deposits;

import bankproduct.BankProduct;
import bankproduct.interfaces.IDeposit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Deposit extends BankProduct implements IDeposit {
    public Deposit(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void closeBankProduct() {
        currency = null;
        balance = 0;
        log.info("Your product: '{}' is closed. Thanks!", name);
    }
}
