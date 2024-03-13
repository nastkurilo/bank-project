package bankproduct.cards;


public class CreditCard extends Card {

    // дополнительный параметр процентная ставка
    private double interestRate;

    public CreditCard(String currency, double balance, String name, double interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    public double getDebtOfCreditCard() {
        return balance < 0 ? Math.abs(balance) : 0;
    }

}
