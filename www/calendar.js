
tabris.registerWidget("ESCalendar", {
  _properties: {
    "date": {type: "any", nocache: true}
  },
  _events: {
    "change:date": {
      trigger: function(event) {
        this.trigger("change:date", this, event.date);
      }
    }
  }
});
