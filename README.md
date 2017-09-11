# Tabris.js Calendar Plugin

A calendar widget for [Tabris.js](https://tabrisjs.com), allowing to show and pick a date. Currently only Android is supported.

![Calendar widget on Android](assets/screenshots/calendar-widget-android.png)

## Example

The following snippet shows how the `tabris-plugin-calendar` plugin can be used in a Tabris.js app:

```javascript
new escalendar.Calendar({
  left: 0, right: 0, top: 0, bottom: 0,
  date: 946684800000 // year 2000
}).on('dateChanged', ({value: date}) => console.log(date))
  .appendTo(tabris.ui.contentView);
```
A more elaborate example can be found in the [example](example/) folder. It provides a Tabris.js project that demonstrates the various features of the `tabris-plugin-calendar` widget. Consult the [README](example/README.md) of the example for build instructions.

## Integrating the plugin
The Tabris.js website provides detailed information on how to [integrate custom widgets](https://tabrisjs.com/documentation/latest/build#adding-plugins) in your Tabris.js app. To add the plugin to your app add the following entry in your apps `config.xml`:

```xml
<plugin name="tabris-plugin-calendar" spec="1.0.0" />
```

To fetch the latest development version use the GitHub URL:

```xml
<plugin name="tabris-plugin-calendar" spec="https://github.com/eclipsesource/tabris-plugin-calendar.git" />
```

## API

The wiget api consists of the object `escalendar.Calendar` with the following properties and events.

### Properties

The following properties can be applied on top of the [common Tabris.js properties](https://tabrisjs.com/documentation/latest/api/Widget#properties):

* `date` : _number_
  * The currently selected date as a unix timestamp in milliseconds
* `minDate` : _number_
  * The minimum date as a unix timestamp in milliseconds.  Defaults to January 1 1900
* `maxDate` : _number_
  * The maximum date as a unix timestamp in milliseconds.  Defaults to January 1 2100

### Events

#### dateChanged

Fired when the user selects a date in the calendar widget.

##### Event parameter
* `event.value`: _number_
  * The new date as a unix timestamp in milliseconds

## Compatibility

Compatible with [Tabris.js 2.0.0](https://github.com/eclipsesource/tabris-js/releases/tag/v2.0.0)

### Supported platforms

 * Android

## Development of the widget

While not required by the consumer or the widget, this repository provides a `project` folder that contains platform specific development artifacts. These artifacts allow to more easily consume the native source code when developing the native parts of the widget.

### Android

The project provides a gradle based build configuration, which also allows to import the project into Android Studio.

In order to reference the Tabris.js specific APIs, the environment variable `TABRIS_ANDROID_PLATFORM` has to point to the Tabris.js Android Cordova platform root directory.

```bash
export TABRIS_ANDROID_PLATFORM=/home/user/tabris-android-cordova
```
 The environment variable is consumed in the gradle projects [build.gradle](project/android/build.gradle) file.

## Copyright

 See [LICENSE](LICENSE) notice.
