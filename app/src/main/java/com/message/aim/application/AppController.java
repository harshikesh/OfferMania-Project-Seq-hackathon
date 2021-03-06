package com.message.aim.application;

import android.app.Application;
import android.util.Log;
import com.message.aim.network.DataManager;

public class AppController extends Application {

  public static final String TAG = AppController.class.getSimpleName();
  // Different Managers
  private DataManager mDataMan;

  @Override public void onCreate() {
    super.onCreate();
    Log.v(TAG, "App started");
    initApp();
  }

  private void initApp() {
    mDataMan = DataManager.getInstance(AppController.this);
    mDataMan.init();
  }

  /**
   * Get the data manager instance
   */
  public synchronized DataManager getDataManager() {
    return mDataMan;
  }

  @Override public void onTerminate() {
    super.onTerminate();
    if (mDataMan != null) {
      mDataMan.terminate();
    }
  }
}
