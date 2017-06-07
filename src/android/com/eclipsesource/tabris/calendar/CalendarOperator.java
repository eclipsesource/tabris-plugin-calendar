package com.eclipsesource.tabris.calendar;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.CalendarView;

import com.eclipsesource.tabris.android.AbstractViewOperator;
import com.eclipsesource.tabris.android.Properties;
import com.eclipsesource.tabris.android.PropertyHandler;
import com.eclipsesource.tabris.android.RemoteObject;
import com.eclipsesource.tabris.android.TabrisContext;

import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarOperator extends AbstractViewOperator<CalendarView> {

  private final Activity activity;
  private final TabrisContext tabrisContext;
  private final CalendarPropertyHandler propertyHandler;

  public CalendarOperator(Activity activity, TabrisContext tabrisContext) {
    super(activity, tabrisContext);
    this.activity = activity;
    this.tabrisContext = tabrisContext;
    propertyHandler = new CalendarPropertyHandler(activity, tabrisContext);
  }

  @Override
  public String getType() {
    return "com.eclipsesource.calendar.Calendar";
  }

  @Override
  public PropertyHandler<CalendarView> getPropertyHandler(CalendarView object) {
    return propertyHandler;
  }

  @Override
  public CalendarView createView(Properties properties) {
    CalendarView calendarView = new CalendarView(activity);
    calendarView.setOnDateChangeListener(new OnDateChangeListener());
    return calendarView;
  }

  private class OnDateChangeListener implements CalendarView.OnDateChangeListener {

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
      GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, dayOfMonth);
      gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
      String date = String.valueOf(gregorianCalendar.getTimeInMillis());
      RemoteObject remoteObject = tabrisContext.getObjectRegistry().getRemoteObjectForObject(calendarView);
      remoteObject.notify("change_date", "date", date);
    }
  }

}
