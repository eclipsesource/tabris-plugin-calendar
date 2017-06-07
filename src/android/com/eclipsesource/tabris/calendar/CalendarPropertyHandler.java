package com.eclipsesource.tabris.calendar;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.CalendarView;

import com.eclipsesource.tabris.android.Properties;
import com.eclipsesource.tabris.android.TabrisContext;
import com.eclipsesource.tabris.android.ViewPropertyHandler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarPropertyHandler extends ViewPropertyHandler<CalendarView> {

  private static final String PROP_DATE = "date";
  private static final String PROP_MIN_DATE = "minDate";
  private static final String PROP_MAX_DATE = "maxDate";

  public CalendarPropertyHandler(Activity activity, TabrisContext tabrisContext) {
    super(activity, tabrisContext);
  }

  @Override
  public void set(CalendarView calendarView, Properties properties) {
    super.set(calendarView, properties);
    for (String property : properties.getAll().keySet()) {
      switch (property) {
        case PROP_DATE:
          calendarView.setDate(Long.parseLong(properties.getString(PROP_DATE)), true, false);
          break;
        case PROP_MIN_DATE:
          calendarView.setMinDate(Long.parseLong(properties.getString(PROP_MIN_DATE)));
          break;
        case PROP_MAX_DATE:
          calendarView.setMaxDate(Long.parseLong(properties.getString(PROP_MAX_DATE)));
          break;
      }
    }
  }

  @Override
  public Object get(CalendarView calendarView, String property) {
    switch (property) {
      case PROP_DATE:
        return timestampToUtcMidnight(calendarView.getDate());
      case PROP_MIN_DATE:
        return timestampToUtcMidnight(calendarView.getMinDate());
      case PROP_MAX_DATE:
        return timestampToUtcMidnight(calendarView.getMaxDate());
    }
    return super.get(calendarView, property);
  }

  @NonNull
  private Object timestampToUtcMidnight(long timestamp) {
    GregorianCalendar date = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    date.setTimeInMillis(timestamp);
    date.set(Calendar.HOUR_OF_DAY, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);
    return String.valueOf(date.getTimeInMillis());
  }

}
