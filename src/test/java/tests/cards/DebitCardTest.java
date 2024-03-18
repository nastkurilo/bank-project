package tests.cards;

import bankproduct.cards.DebitCard;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.helpers.RandomDataGetter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DebitCardTest {
    private DebitCard debitCard;

    @BeforeMethod
    public void createDebitCard() {
        debitCard = new DebitCard(RandomDataGetter.getRandomCurrency(), RandomDataGetter.getRandomNumberDouble(0, 10000),
                RandomDataGetter.getRandomName());
    }

    @Test
    public void testReplenishBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = debitCard.getBalance();
        debitCard.replenishBalance(value);
        var actualBalance = debitCard.getBalance();
        assertEquals(actualBalance - beforeBalance, value);
    }

    @Test
    public void testReplenishBalanceNegative() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = debitCard.getBalance();
        debitCard.replenishBalance(-value);
        var actualBalance = debitCard.getBalance();
        assertEquals(actualBalance, beforeBalance);
    }

    @Test
    public void testWriteOffBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(1, 1000);
        var beforeBalance = debitCard.getBalance();
        debitCard.writeOffBalance(value);
        var actualBalance = debitCard.getBalance();
        assertEquals(beforeBalance - actualBalance, value);
    }

    @Test
    public void testWriteOffBalanceNegative() {
        double value = RandomDataGetter.getRandomNumberDouble(1, 1000);
        var beforeBalance = debitCard.getBalance();
        debitCard.writeOffBalance(-value);
        var actualBalance = debitCard.getBalance();
        assertEquals(beforeBalance, actualBalance);
        assertNotEquals(beforeBalance - actualBalance, value);
    }

}