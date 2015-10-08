# react-native-android-vitamio

A React-native component for android [Vitamio video player](https://github.com/yixia/VitamioBundle).

### Installation 

```bash
npm install --save react-native-android-vitamio
```

### Add it to your android project

* In `android/setting.gradle`

TODO

* In `android/app/build.gradle`

TODO

```java
import com.ivanph.webintent.RNWebIntentPackage;;  // <--- import

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
    var TouchableElement = TouchableHighlight;
    if (Platform.OS === 'android') {
      TouchableElement = TouchableNativeFeedback;
    }
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
## License

MIT