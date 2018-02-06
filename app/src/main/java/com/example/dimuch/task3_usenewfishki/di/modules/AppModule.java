package com.example.dimuch.task3_usenewfishki.di.modules;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Dimuch on 02.10.2017.
 */

@Module (includes = { DataModule.class }) public class AppModule {

  private final Application mApplication;

  public AppModule(Application mApplication) {
    this.mApplication = mApplication;
  }

  @Provides Context provideAppContext() {
    return mApplication;
  }

}
