package bankproduct.cards;

import bankproduct.BankProduct;
import interfaces.GeneralMethodeForCard;

public abstract class Card extends BankProduct implements GeneralMethodeForCard {

    public Card(String currency, double balance, String name) {
        super(currency, balance, name);
    }

}
