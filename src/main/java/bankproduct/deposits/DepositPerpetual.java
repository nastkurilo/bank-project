package bankproduct.deposits;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DepositPerpetual extends Deposit{
    public DepositPerpetual(String currency, double balance, String name) {
        super(currency, balance, name);
    }
}
