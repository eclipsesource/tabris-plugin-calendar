class Calendar extends tabris.Widget {

  get _nativeType() {
    return 'com.eclipsesource.calendar.Calendar';
  }

  _listen(name, listening) {
    if (name === 'dateChanged') {
      this._nativeListen('dateChanged', listening);
    } else {
      super._listen(name, listening);
    }
  }

  _trigger(name, event) {
    if (name === 'dateChanged') {
      this._triggerChangeEvent('date', parseInt(event.date));
    } else {
      return super._trigger(name, event);
    }
  }

}

tabris.NativeObject.defineProperties(Calendar.prototype, {
  'date': {
    type: 'number',
    nocache: true,
    encode(value) {
      return value.toString();
    },
    decode(value) {
      return parseInt(value);
    }
  },
  'minDate': {
    type: 'number',
    nocache: true,
    encode(value) {
      return value.toString();
    },
    decode(value) {
      return parseInt(value);
    }
  },
  'maxDate': {
    type: 'number',
    nocache: true,
    encode(value) {
      return value.toString();
    },
    decode(value) {
      return parseInt(value);
    }
  }
});

module.exports = Calendar;
