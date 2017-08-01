const {Button, CheckBox, Composite, TextView, ui} = require('tabris');

let calendar = new escalendar.Calendar({
  left: 0, right: 0, top: 0, bottom: '#controls',
  background: '#fafafa'
}).on('dateChanged', ({value: date}) => textView.text = new Date(date).toUTCString())
  .appendTo(ui.contentView);

let controls = new Composite({
  id: 'controls',
  left: 0, right: 0, bottom: 0,
  background: 'white',
  elevation: 12
}).appendTo(ui.contentView);

let textView = new TextView({
  left: 16, right: 16, top: 0, height: 48,
  font: 'italic 16px',
  alignment: 'center',
  text: new Date(calendar.date).toUTCString()
}).appendTo(controls);

new Composite({
  left: 0, right: 0, top: 'prev()', height: 1,
  background: '#e0e0e0'
}).appendTo(controls);

new CheckBox({
  left: 16, right: 16, top: 'prev() 16',
  text: 'Limit to 7 days in the past',
}).on('checkedChanged', ({value: checked}) => calendar.minDate = checked ? Date.now() - 604800000 : 0)
  .appendTo(controls);

new CheckBox({
  left: 16, right: 16, top: 'prev() 16',
  text: 'Limit to 7 days in the future',
}).on('checkedChanged', ({value: checked}) => calendar.maxDate = checked ? Date.now() + 604800000 : 4099680000000)
  .appendTo(controls);

new Button({
  left: 16, right: 16, top: 'prev() 8', bottom: 16,
  text: 'Set to year 2000',
}).on('select', () => calendar.date = 946684800000)
  .appendTo(controls);
