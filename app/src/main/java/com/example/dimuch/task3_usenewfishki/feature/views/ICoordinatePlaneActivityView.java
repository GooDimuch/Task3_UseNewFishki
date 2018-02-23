package com.example.dimuch.task3_usenewfishki.feature.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by Dimuch on 06.02.2018.
 */

@StateStrategyType(AddToEndStrategy.class) public interface ICoordinatePlaneActivityView
    extends MvpView {

  void showToast(String sToastMessage);

  void showGraph(LineGraphSeries<DataPoint> series);

  void configureGraph(int minX, int maxX, int minY, int maxY, boolean scaleX, boolean scaleY);
}
