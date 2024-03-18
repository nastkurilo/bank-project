package tests.deposits;

import bankproduct.deposits.DepositPerpetual;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.helpers.RandomDataGetter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DepositTest {

    private DepositPerpetual depositPerpetual;

    @BeforeMethod
    public void createDebitCard() {
        depositPerpetual = new DepositPerpetual(RandomDataGetter.getRandomCurrency(), RandomDataGetter.getRandomNumberDouble(0, 10000),
                RandomDataGetter.getRandomName());
    }

    @Test
    public void testReplenishBalance() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = depositPerpetual.getBalance();
        depositPerpetual.replenishBalance(value);
        var actualBalance = depositPerpetual.getBalance();
        assertEquals(actualBalance - beforeBalance, value);
    }

    @Test
    public void testReplenishBalanceNegative() {
        double value = RandomDataGetter.getRandomNumberDouble(0, 10000);
        var beforeBalance = depositPerpetual.getBalance();
        depositPerpetual.replenishBalance(-value);
        var actualBalance = depositPerpetual.getBalance();
        assertEquals(actualBalance, beforeBalance);
    }

    @Test
    public void testCloseDeposit() {
        var beforeBalance = depositPerpetual.getBalance();
        depositPerpetual.closeBankProduct();
        var actualBalance = depositPerpetual.getBalance();
        assertNotEquals(beforeBalance, 0);
        assertEquals(actualBalance, 0);
    }

}
