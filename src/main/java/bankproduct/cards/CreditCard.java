package bankproduct.cards;


import lombok.Getter;

@Getter
public class CreditCard extends Card {

    // дополнительный параметр процентная ставка
    private double interestRate;

    public CreditCard(String currency, double balance, String name, double interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    /**
     * Запрос на вычисление задолжности по кредиту
     *
     * @param loanAmount: суммы кредита
     *                    interestRate : процентная ставка
     */
    public double getDebtOfCreditCard(double loanAmount) {
        double sum = 0;
        if (balance >= loanAmount && balance > 0) {
            log.info("You have no outstanding credit!");
            return sum;
        } else if (balance > 0){
            int period = 5; // просроченный период
            sum = Math.round((loanAmount - balance) * interestRate / 100 / 365 * period) * 1000 / 1000.0;
            log.info("You should pay sum: '{}'", sum);
            return sum;
        }
        return sum;
    }
}
