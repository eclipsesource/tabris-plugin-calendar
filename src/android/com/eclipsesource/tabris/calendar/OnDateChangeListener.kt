package com.eclipsesource.tabris.calendar

import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import com.eclipsesource.tabris.android.Scope
import java.util.*

class OnDateChangeListener(private val scope: Scope) : OnDateChangeListener {

  override fun onSelectedDayChange(calendarView: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
    val calendar = GregorianCalendar(year, month, dayOfMonth).apply {
      timeZone = TimeZone.getTimeZone("UTC")
    }
    scope.remoteObject(calendarView)?.notify("dateChanged", "date", calendar.timeInMillis)
  }

}
