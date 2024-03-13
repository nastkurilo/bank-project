package interfaces;

public interface GeneralMethodeForCard {

    // пополнение
    void replenishBalance(double amount);

    // списание
    void writeOffBalance(double amount);

    // запрос баланса
    void getBalance(double amount);
}
