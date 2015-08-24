
package com.eclipsesource.tabris.calendar;

import android.app.Activity;
import android.widget.CalendarView;

import com.eclipsesource.tabris.android.TabrisContext;
import com.eclipsesource.tabris.android.TabrisWidgetPropertyHandler;
import com.eclipsesource.tabris.client.core.model.Properties;

public class CalendarWidgetPropertyHandler extends TabrisWidgetPropertyHandler<CalendarView> {

  public CalendarWidgetPropertyHandler( Activity activity, TabrisContext tabrisContext ) {
    super( activity, tabrisContext );
  }

  @Override
  public void set( CalendarView view, Properties properties ) {
    super.set( view, properties );
    if( properties.hasProperty( "date" ) ) {
      view.setDate( properties.getLong( "date" ), true, false );
    }
  }

  @Override
  public Object get( CalendarView view, String property ) {
    if( property.equals( "date" ) ) {
      return String.valueOf( view.getDate() );
    } else {
      return super.get( view, property );
    }
  }

}
