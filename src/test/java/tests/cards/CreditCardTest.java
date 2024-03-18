package tests.cards;

import bankproduct.cards.CreditCard;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.helpers.RandomDataGetter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CreditCardTest {
    private CreditCard creditCard;
    private double percentRate;

    @BeforeMethod
    public void createCreditCard() {
        percentRate = RandomDataGetter.getRandomPercentRate();
        creditCard = new CreditCard(RandomDataGetter.getRandomCurrency(), RandomDataGetter.getRandomNumberDouble(0, 10000),
                RandomDataGetter.getRandomName(), percentRate);
    }



    @Test
    public void testPercentRate() {
        assertEquals(creditCard.getInterestRate(), percentRate);
    }

    @Test
    public void testReplenishBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = creditCard.getBalance();
        creditCard.replenishBalance(value);
        var actualBalance = creditCard.getBalance();
        assertEquals(actualBalance - beforeBalance, value);
    }

    @Test
    public void testReplenishBalanceNegative() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = creditCard.getBalance();
        creditCard.replenishBalance(-value);
        var actualBalance = creditCard.getBalance();
        assertEquals(beforeBalance, actualBalance);
    }

    @Test
    public void testWriteOffBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(1, 1000);
        var beforeBalance = creditCard.getBalance();
        creditCard.writeOffBalance(value);
        var actualBalance = creditCard.getBalance();
        assertEquals(beforeBalance - actualBalance, value);
    }

    @Test
    public void testGetDebtOfCreditCard() {
        double value = RandomDataGetter.getRandomNumberDouble(1, 1000);
        assertNotEquals(creditCard.getDebtOfCreditCard(value), 0);
    }

    @Test
    public void testGetDebtOfCreditCardNegative() {
        assertEquals(creditCard.getDebtOfCreditCard(0), 0);
    }

    @Test
    public void testGetDebtOfCreditCardWithDebt() {
        assertNotEquals(creditCard.getDebtOfCreditCard(12345678.0), 0);
    }

}
