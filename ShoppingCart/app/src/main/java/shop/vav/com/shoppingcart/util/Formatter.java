package shop.vav.com.shoppingcart.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by z179905 on 9/19/17.
 */

public class Formatter {

    public static String formatCurrency(double amount){
        NumberFormat baseFormat = NumberFormat.getCurrencyInstance();
        String moneyString = baseFormat.format(amount);
        return moneyString;
    }
    public static String formatDate(long date){
        String displayDate = new SimpleDateFormat("MM dd").format(new Date(date));
        return displayDate;
    }
}
