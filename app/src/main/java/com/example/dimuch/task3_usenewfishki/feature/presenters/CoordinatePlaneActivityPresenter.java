package com.example.dimuch.task3_usenewfishki.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task3_usenewfishki.App;
import com.example.dimuch.task3_usenewfishki.feature.views.ICoordinatePlaneActivityView;
import com.example.dimuch.task3_usenewfishki.feature.views.IMainActivityView;
import javax.inject.Inject;

/**
 * Created by Dimuch on 06.02.2018.
 */

@InjectViewState public class CoordinatePlaneActivityPresenter extends MvpPresenter<ICoordinatePlaneActivityView> {

  //@Inject DataManager mDataManager;

  public CoordinatePlaneActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

  }
}
