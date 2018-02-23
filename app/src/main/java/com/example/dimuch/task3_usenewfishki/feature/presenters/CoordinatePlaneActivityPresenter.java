package com.example.dimuch.task3_usenewfishki.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task3_usenewfishki.App;
import com.example.dimuch.task3_usenewfishki.feature.views.ICoordinatePlaneActivityView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by Dimuch on 06.02.2018.
 */

@InjectViewState public class CoordinatePlaneActivityPresenter
    extends MvpPresenter<ICoordinatePlaneActivityView> {
  private static final int LENGTH = 1000;
  //private static final boolean IS_SCALE = true;
  private static final boolean IS_SCALE = false;

  //@Inject DataManager mDataManager;

  public CoordinatePlaneActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    getViewState().configureGraph(-100, 100, -100, 100, IS_SCALE, IS_SCALE);

    //DataPoint[] points = buildFunc2();
    //LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);
    //series.setTitle("Random Curve");
    //getViewState().showGraph(series);
  }

  private DataPoint[] buildFunc2() {
    DataPoint[] points = new DataPoint[LENGTH];
    for (int i = 0; i < points.length; i++) {
      points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
    }
    return points;
  }
}
