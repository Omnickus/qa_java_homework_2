package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersTools {

    public static boolean isNumber(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9]{1,99}$");
        Matcher matcher = pattern.matcher(number);
        boolean isNumber = matcher.find();
        return isNumber;
    }
}
