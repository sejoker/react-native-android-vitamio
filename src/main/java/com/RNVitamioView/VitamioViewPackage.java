package com.sejoker.VitamView;

import android.app.Activity;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VitamioViewPackage implements ReactPackage {

    private Activity mActivity = null;

    public VitamioViewPackage(Activity activity) {
        mActivity = activity;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new VitamioViewManager(mActivity)
        );
    }
}
