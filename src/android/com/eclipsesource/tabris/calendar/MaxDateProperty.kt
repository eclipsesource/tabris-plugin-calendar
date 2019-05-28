package com.eclipsesource.tabris.calendar

import android.widget.CalendarView
import com.eclipsesource.tabris.android.StringProperty
import java.util.*

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
object MaxDateProperty : StringProperty<CalendarView>("maxDate") {

  override fun set(calendarView: CalendarView, date: String?) {
    date?.let {
      calendarView.maxDate = it.toLong()
    }
  }

  override fun get(calendarView: CalendarView) =
      GregorianCalendar(TimeZone.getTimeZone("UTC")).apply {
        timeInMillis = calendarView.maxDate
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
      }.timeInMillis.toString()

}
