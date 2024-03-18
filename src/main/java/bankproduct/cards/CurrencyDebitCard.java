package bankproduct.cards;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurrencyDebitCard extends Card{
    public CurrencyDebitCard(String currency, double balance, String name) {
        super(currency, balance, name);
    }

}
