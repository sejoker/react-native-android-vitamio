package com.sejoker.VitamView;

import javax.annotation.Nullable;

import android.app.Activity;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.BaseViewPropertyApplicator;
import com.facebook.react.uimanager.CatalystStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.text.ReactTextShadowNode;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VitamioViewManager extends SimpleViewManager<VideoView> {
    public static final String REACT_CLASS = "RCTVitamioView";

    private Activity mActivity = null;

    private ThemedReactContext mContext = null;

    public VitamioViewManager(Activity activity) {
      mActivity = activity;
    }

    @Override
    public String getName() {
      return REACT_CLASS;
    }

    @Override
    public VideoView createViewInstance(ThemedReactContext context) {
      mContext = context;
      return new VideoView(context);
    }

    @ReactProp(name = "streamUrl")
    public void setStreamUrl(VideoView view, @Nullable String streamUrl) {
      if (!LibsChecker.checkVitamioLibs(mActivity))
        return;

      view.setVideoPath(streamUrl);

      view.setMediaController(new MediaController(mContext));
      view.requestFocus();

      view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
          // optional need Vitamio 4.0
          mediaPlayer.setPlaybackSpeed(1.0f);
        }
      });
    }
}
