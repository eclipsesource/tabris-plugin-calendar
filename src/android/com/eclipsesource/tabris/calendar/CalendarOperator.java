
package com.eclipsesource.tabris.calendar;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.eclipsesource.tabris.android.AbstractTabrisOperator;
import com.eclipsesource.tabris.android.TabrisContext;
import com.eclipsesource.tabris.android.TabrisPropertyHandler;
import com.eclipsesource.tabris.client.core.RemoteObject;
import com.eclipsesource.tabris.client.core.model.Properties;

import java.util.GregorianCalendar;

public class CalendarOperator extends AbstractTabrisOperator<CalendarView> {

  private final Activity activity;
  private final TabrisContext tabrisContext;
  private final TabrisPropertyHandler<CalendarView> propertyHandler;

  public CalendarOperator( Activity activity, TabrisContext tabrisContext ) {
    this.activity = activity;
    this.tabrisContext = tabrisContext;
    propertyHandler = new CalendarWidgetPropertyHandler( activity, tabrisContext );
  }

  @Override
  public String getType() {
    return "ESCalendar";
  }

  @Override
  public TabrisPropertyHandler<CalendarView> getPropertyHandler() {
    return propertyHandler;
  }

  @Override
  public CalendarView create( Properties properties ) {
    CalendarView calendarView = new CalendarView( activity );
    calendarView.setOnDateChangeListener( new OnDateChangeListener() );
    return calendarView;
  }

  @Override
  public void destroy( CalendarView calendarView ) {
    ( ( ViewGroup )calendarView.getParent() ).removeView( calendarView );
  }

  private class OnDateChangeListener implements CalendarView.OnDateChangeListener {

    @Override
    public void onSelectedDayChange( CalendarView view, int year, int month, int dayOfMonth ) {
      String date = String.valueOf( new GregorianCalendar( year, month, dayOfMonth + 1 ).getTimeInMillis() );
      RemoteObject remoteObject = tabrisContext.getObjectRegistry().getRemoteObjectForObject( view );
      remoteObject.notify( "change:date", "date", date );
    }
  }

}
