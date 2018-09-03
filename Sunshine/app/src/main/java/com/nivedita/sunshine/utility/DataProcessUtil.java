package com.nivedita.sunshine.utility;

import android.content.Context;

/**
 * Class used to process the date utils.
 */

public class DataProcessUtil {

    public static String formatHighLows(Context context, double high, double low) {

        long roundedHigh = Math.round(high);
        long roundedLow = Math.round(low);

        String highLowStr = roundedHigh + "/" + roundedLow;
        return highLowStr;
    }

}
