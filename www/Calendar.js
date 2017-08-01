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
    set(name, value) {
      this._nativeSet(name, value.toString());
    },
    get(name) {
      return parseInt(this._nativeGet(name));
    }
  },
  'minDate': {
    type: 'number',
    nocache: true,
    set(name, value) {
      this._nativeSet(name, value.toString());
    },
    get(name) {
      return parseInt(this._nativeGet(name));
    }
  },
  'maxDate': {
    type: 'number',
    nocache: true,
    set(name, value) {
      this._nativeSet(name, value.toString());
    },
    get(name) {
      return parseInt(this._nativeGet(name));
    }
  }
});

module.exports = Calendar;
