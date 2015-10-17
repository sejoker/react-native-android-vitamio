# react-native-android-vitamio

A React-native component for android [Vitamio video player](https://github.com/yixia/VitamioBundle).

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
project(':RNVitamioView').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-vitamio')```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':RNVitamioView')
}
```

* register module (in MainActivity.java)

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

## License

MIT