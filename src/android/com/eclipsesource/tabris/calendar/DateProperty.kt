package com.eclipsesource.tabris.calendar

import android.widget.CalendarView
import com.eclipsesource.tabris.android.StringProperty
import java.util.*

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
object DateProperty : StringProperty<CalendarView>("date") {

  override fun set(calendarView: CalendarView, date: String?) {
    date?.let {
      calendarView.setDate(it.toLong(), true, false)
    }
  }

  override fun get(calendarView: CalendarView) =
      GregorianCalendar(TimeZone.getTimeZone("UTC")).apply {
        timeInMillis = calendarView.date
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
      }.timeInMillis.toString()

}
