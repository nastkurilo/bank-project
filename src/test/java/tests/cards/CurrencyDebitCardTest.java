package tests.cards;

import bankproduct.cards.CurrencyDebitCard;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.helpers.RandomDataGetter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CurrencyDebitCardTest {

    private CurrencyDebitCard currencyDebitCard;

    @BeforeMethod
    public void createCurrencyDebitCard() {
        currencyDebitCard = new CurrencyDebitCard(RandomDataGetter.getRandomCurrency(), RandomDataGetter.getRandomNumberDouble(0, 10000),
                RandomDataGetter.getRandomName());
    }

    @Test
    public void testReplenishBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = currencyDebitCard.getBalance();
        currencyDebitCard.replenishBalance(value);
        var actualBalance = currencyDebitCard.getBalance();
        assertEquals(actualBalance - beforeBalance, value);
    }

    @Test
    public void testReplenishBalanceNegative() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = currencyDebitCard.getBalance();
        currencyDebitCard.replenishBalance(-value);
        var actualBalance = currencyDebitCard.getBalance();
        assertEquals(actualBalance, beforeBalance);
    }

    @Test
    public void testWriteOffBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(1, 1000);
        var beforeBalance = currencyDebitCard.getBalance();
        currencyDebitCard.writeOffBalance(value);
        var actualBalance = currencyDebitCard.getBalance();
        assertEquals(beforeBalance - actualBalance, value);
    }

    @Test
    public void testWriteOffBalanceNegative() {
        double value = RandomDataGetter.getRandomNumberDouble(1, 1000);
        var beforeBalance = currencyDebitCard.getBalance();
        currencyDebitCard.writeOffBalance(-value);
        var actualBalance = currencyDebitCard.getBalance();
        assertEquals(beforeBalance, actualBalance);
        assertNotEquals(beforeBalance - actualBalance, value);
    }

}
