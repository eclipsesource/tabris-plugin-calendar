package com.eclipsesource.tabris.calendar

import android.widget.CalendarView
import com.eclipsesource.tabris.android.ActivityScope
import com.eclipsesource.tabris.android.Property
import com.eclipsesource.tabris.android.internal.nativeobject.view.ViewHandler
import com.eclipsesource.v8.V8Object

open class CalendarHandler(private val scope: ActivityScope) : ViewHandler<CalendarView>(scope) {

  override val type = "com.eclipsesource.calendar.Calendar"

  override val properties: List<Property<CalendarView, *>> = listOf(
      DateProperty,
      MaxDateProperty,
      MinDateProperty
  )

  override fun create(id: String, properties: V8Object) = CalendarView(scope.activity).also {
    it.setOnDateChangeListener(OnDateChangeListener(scope))
  }

}
