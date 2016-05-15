
# react-native-android-vitamio

A React-native component for android [Vitamio video player](https://github.com/yixia/VitamioBundle).


Supports React Native 0.21.

### Demo app

https://github.com/sejoker/react-native-vitamio-demo

### Installation 

```bash
npm install --save react-native-android-vitamio
```

### Add it to your android project

* In `android/setting.gradle`

```gradle
...
include ':vitamio'
project(':vitamio').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-vitamio/vitamio')
include ':RNVitamioView'
project(':RNVitamioView').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-vitamio')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':RNVitamioView')
}
```

* register module on React Native >= 0.18 (in MainActivity.java)
```java
package com.vitamio_demo;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import com.sejoker.VitamView.VitamioViewPackage; // <--- import

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "vitamio_demo";
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

   /**
   * A list of packages used by the app. If the app uses additional views
   * or modules besides the default ones, add more packages here.
   */
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
        new MainReactPackage(),
        new VitamioViewPackage(this)          // <------ add here
      );
    }
}

```

* register module on React Native < 0.18 (in MainActivity.java)
```java
import com.sejoker.VitamView.VitamioViewPackage;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new VitamioViewPackage(this))              // <------ add here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "app", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Example
```javascript
var VitamioView = require('react-native-android-vitamio');

class VideoScreen extends React.Component {
  render() {
    return (
      <View>
        <VitamioView style={styles.video} streamUrl="rtmp://fms.12E5.edgecastcdn.net/0012E5/mp4:videos/8Juv1MVa-485.mp4"/>
      </View>
    );
  }
}


var styles = StyleSheet.create({
  video: {
      flex: 1,
      flexDirection: 'row',
      height: 400,
    }
})

module.exports = VideoScreen;
```

### Known issues

Vitamio doesn't play video in android simulator.
Video doesn't start automatically, touch the screen and press start.

## License

MIT