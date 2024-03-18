package bankproduct.cards;

import bankproduct.BankProduct;
import bankproduct.interfaces.ICard;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

public abstract class Card extends BankProduct implements ICard {

    protected static final Logger log = org.slf4j.LoggerFactory.getLogger(BankProduct.class);


    public Card(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void writeOffBalance(double amount) {
        if (amount >= 0 && balance >= amount) {
            if (balance - amount >= 0) {
                balance -= amount;
                log.info("Your balance has been written off: {} amounts. Current balance is: {}", amount, balance);
            } else {
                log.info("Insufficient funds. Withdrawal failed.");
            }
        }
    }

}
