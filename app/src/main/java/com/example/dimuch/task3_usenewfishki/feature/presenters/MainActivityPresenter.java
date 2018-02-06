package com.example.dimuch.task3_usenewfishki.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task3_usenewfishki.App;
import com.example.dimuch.task3_usenewfishki.feature.views.IMainActivityView;
import javax.inject.Inject;

/**
 * Created by Dimuch on 06.02.2018.
 */

@InjectViewState public class MainActivityPresenter extends MvpPresenter<IMainActivityView> {

  @Inject String testMessage;
  //@Inject DataManager mDataManager;

  public MainActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    getViewState().showToast(testMessage);
  }
}
