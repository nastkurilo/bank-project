package tests.helpers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class RandomDataGetter {

    public static double getRandomNumberDoubleWithFormat(int low, int high) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.###", symbols);
        double value = Math.random() * (high - low) + low;
        return Double.parseDouble(df.format(value));
    }

    public static int getRandomNumberInt(int low, int high) {
        return (int) (Math.random() * (high - low) + low);
    }

    public static double getRandomNumberDouble(int low, int high) {
        return Math.round((Math.random() * (high - low) + low)) * 1000 / 1000.0;
    }

    public static String getRandomName() {
        return NAMES.get(getRandomNumberInt(0, NAMES.size() - 1));
    }

    public static double getRandomPercentRate() {
        return Math.round(getRandomNumberDouble(0, 20)) * 100 / 100.0;
    }

    public static String getRandomCurrency() {
        return CURRENCY.get(getRandomNumberInt(0, CURRENCY.size() - 1));
    }

    private static final List<String> NAMES = List.of(
            "Альфа Банк", "Банк БелВЭБ", "Банк ВТБ",
            "Банк Дабрабыт", "Банк Решение", "Белагропромбанк",
            "Беларусбанк", "Белгазпромбанк", "Белинвестбанк",
            "БНБ-Банк", "МТБанк", "Сбер Банк", "СтатусБанк",
            "СтатусБанк", "ТК Банк", "Цептер Банк");

    private static final List<String> CURRENCY = List.of( "USD", "EUR", "GBP",
            "JPY", "CAD","AUD", "CHF", "CNY", "SEK", "NZD");
}
