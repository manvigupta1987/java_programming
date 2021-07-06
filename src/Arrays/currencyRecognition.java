package Arrays;

// I was given a string currency e.g $459.99
//
//I had to return whether the currency is valid or not based on following rules:
//
//if currency is base 10 int
//if there is only dollar, yen and pounds symbol at start
//there can be commas (optional), if they are present make sure they are at every thousand
//there can be decimal points, if found they should be exactly 2 precision point long
//if the amount is negative it could be before the currency symbol or around brackets e.g -$45 is okay, -($45) is also okay rest are not
//if there are any leading or trailing zeros or whitespaces return false
//if the currency is yen, it can't have decimals
//if the currency is empty return false

public class currencyRecognition {
    public static boolean isYen = false;
    public static String checkForCurrencySign(String currency) {
        char ch = currency.charAt(0);
        if (ch == '$' || ch == '€' || ch == '¥') {
            if(ch == '¥')  isYen = true;
            return currency.substring(1);
        }
        return "";
    }

    public static String checkForNegative(String currency) {
        if (currency.charAt(0) == '-') {
            if (currency.charAt(1) == '(') {
                if (currency.charAt(currency.length() - 1) == ')') {
                    return checkForCurrencySign(currency.substring(2));
                } else {
                    return "";
                }
            } else {
                return checkForCurrencySign(currency.substring(1));
            }
        }
        return checkForCurrencySign(currency);
    }

    public static String checkForBase10(String currency) {
        for (int i =0; i<currency.length(); i++) {
            if(currency.charAt(i) == '.') {
                continue;
            }

            if (!( currency.charAt(i) >= '0' && currency.charAt(i) <=('0' + 10))) {
                return "";
            }
        }
        return currency;
    }

    public static String checkForValildNumber(String currency) {
        String REGEX = "^\\d{1,3}|\\d(([ ,]?\\d{3})*([.,]\\d{2}+)?$)";
        if (!Character.isDigit(currency.charAt(0))) {
            return "";
        }
        if (checkForBase10(currency).length() == 0) {
            return "";
        }
        boolean decimal = currency.contains(".");
        if (isYen && decimal) {
            return "";
        }
        return currency.matches(REGEX) ? currency : "";
//        int decimalIndex = currency.indexOf(".");
//        if (currency.length() - decimalIndex > 2) {
//            return "";
//        }
//        boolean comma = currency.contains(",");
    }


    public static boolean checkIfCurrencyValid(String currency) {
        if (currency.length() == 0) {
            return false;
        }
        currency = checkForNegative(currency);
        if (currency.length() == 0) {
            return false;
        }

        currency = checkForValildNumber(currency);
        return currency.length() != 0;
    }
    public static void main(String[] args) {
        String currency = "$459.99";
        System.out.println(checkIfCurrencyValid(currency));
    }
}
