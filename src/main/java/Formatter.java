import java.math.BigDecimal;

public class Formatter {
    public static String getCurrencyText(BigDecimal price) {
        String roundPrice = price.toBigInteger().toString();
        String currency;
        if (roundPrice.length()>1){
            int lastDigits = Integer.parseInt(roundPrice.substring(roundPrice.length() - 2));
            if(lastDigits>10&&lastDigits<20){
                return "рублей";
            }
        }
        int lastDigit = Integer.parseInt(roundPrice.substring(roundPrice.length() - 1));

        if (lastDigit == 1) {
            currency = "рубль";
        } else if (lastDigit == 2 || lastDigit == 3 || lastDigit == 4) {
            currency = "рубля";
        } else {
            currency = "рублей";
        }
        return currency;
    }
}
