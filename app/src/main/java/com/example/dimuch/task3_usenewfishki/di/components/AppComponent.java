package com.example.dimuch.task3_usenewfishki.di.components;

import com.example.dimuch.task3_usenewfishki.di.modules.AppModule;
import com.example.dimuch.task3_usenewfishki.feature.presenters.MainActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules = AppModule.class) @Singleton public interface AppComponent {

  void inject(MainActivityPresenter mainActivityPresenter);

  //void inject(CameraActivityPresenter cameraActivityPresenter);
}