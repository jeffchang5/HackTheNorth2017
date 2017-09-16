package com.mhacks.android.ui.common;

import android.widget.DatePicker;
import android.widget.TimePicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Damian Wieczorek <damianw@umich.edu> on 7/28/14.
 */
public abstract class Util {

    // Various formatting tools for Date, String, etc
    public static abstract class Time {

        public static final double MINUTES_PER_HOUR = 60;

        private static final SimpleDateFormat sDateFormat      =
                new SimpleDateFormat("EEEE, MMMM d");
        private static final SimpleDateFormat sShortTimeFormat = new SimpleDateFormat("ha");
        private static final SimpleDateFormat sLongTimeFormat  = new SimpleDateFormat("h:mma");

        public static String formatDate(Date date) {
            return sDateFormat.format(date);
        }

        public static String roundTimeAndFormat(Date date, int partsPerHour) {
            Calendar calendar = roundTime(date, partsPerHour);
            SimpleDateFormat format =
                    calendar.get(Calendar.MINUTE) == 0 ? sShortTimeFormat : sLongTimeFormat;

            return format.format(calendar.getTime());
        }

        // to round to 1hr, use partsPerHour = 1,
        // to round to 30m, use partsPerHour = 2,
        // to round to 15m, use partsPerHour = 4... etc
        public static Calendar roundTime(Date date, int partsPerHour) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);

            calendar.set(Calendar.MINUTE,
                         (int) (Math.floor(
                                 calendar.get(Calendar.MINUTE) * partsPerHour / MINUTES_PER_HOUR +
                                 0.5) * (MINUTES_PER_HOUR / partsPerHour)));
            return calendar;
        }

        public static Calendar fromPickers(DatePicker datePicker, TimePicker timePicker) {
            Calendar calendar = GregorianCalendar.getInstance();

            calendar.set(Calendar.YEAR, datePicker.getYear());
            calendar.set(Calendar.MONTH, datePicker.getMonth());
            calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());

            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

            return calendar;
        }

    }

    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {

            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
                //Read byte from input stream

                int count=is.read(bytes, 0, buffer_size);
                if(count==-1)
                    break;

                //Write byte from output stream
                os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
}