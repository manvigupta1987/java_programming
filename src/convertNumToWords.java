public class convertNumToWords {
    private static final String[] units = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine"
    };
    private static final String[] twoDigits = {
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };
    private static final String[] tenMultiples = {
            "",
            "",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };
    private static final String[] placeValues = {
            " ",
            " thousand",
            " million",
            " billion",
            " trillion"
    };

    private static String convertNumber(long number) {
        String word = "";
        int index = 0;

        do {
            int num = (int)(number % 1000);
            if (num != 0) {
                String str = convertNumberUptoThreeDigits(num);
                word = str + placeValues[index] + word;
            }
            index++;

            number = number / 1000;
        } while (number > 0);
        return word;
    }

    private static String convertNumberUptoThreeDigits(int num) {
        String word = "";
        int num1 = num % 100;
        if (num1 < 10) {
            word += units[num1];
        } else if (num1 < 20) {
            word += twoDigits[num1 % 10];
        } else {
            word += tenMultiples[num1/10] + units[num1 % 10];
        }
        word = (num > 100) ? units[num/100] + " hundred" + word : word;
        return word;
    }

    // Driver Code
    public static void main(String[] args)
    {
        System.out.println("1234123456789- " + convertNumber(1234123456789L));
        System.out.println("123456789- " + convertNumber(123456789));
        System.out.println("37565820- " + convertNumber(37565820));
        System.out.println("9341947- " + convertNumber(9341947));
        System.out.println("37000- " + convertNumber(37000));
        System.out.println("1387- " + convertNumber(1387));
        System.out.println("10- " + convertNumber(10));
        System.out.println("41- " + convertNumber(41));
    }
}
