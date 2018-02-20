package com.example.dimuch.task3_usenewfishki.feature.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Dimuch on 20.02.2018.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IFirebaseActivityView extends MvpView {

  void showToast(String sToastMessage);
}
