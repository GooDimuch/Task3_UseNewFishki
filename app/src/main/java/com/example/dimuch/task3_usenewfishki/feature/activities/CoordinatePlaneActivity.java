package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.feature.fragments.CoordinatePaneDialogFragment;
import com.example.dimuch.task3_usenewfishki.feature.presenters.CoordinatePlaneActivityPresenter;
import com.example.dimuch.task3_usenewfishki.feature.views.ICoordinatePlaneActivityView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import timber.log.Timber;

public class CoordinatePlaneActivity extends MvpAppCompatActivity
    implements ICoordinatePlaneActivityView {

  private static final int MY_REQUEST_CODE = 1;
  @BindView(R.id.gvCoordinatePlane) GraphView gvCoordinatePlane;

  @InjectPresenter CoordinatePlaneActivityPresenter coordinatePlaneActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coordinate_plane);
    ButterKnife.bind(this);

    gvCoordinatePlane.setOnLongClickListener(view -> {
      Timber.wtf("LongClick");
      CoordinatePaneDialogFragment coordinatePaneDialogFragment =
          new CoordinatePaneDialogFragment();
      coordinatePaneDialogFragment.setTargetFragment(coordinatePaneDialogFragment, MY_REQUEST_CODE);
      coordinatePaneDialogFragment.show(getFragmentManager(), "dialog");

      return true;
    });
  }

  @Override public void showGraph(LineGraphSeries<DataPoint> series) {
    gvCoordinatePlane.addSeries(series);
    gvCoordinatePlane.getLegendRenderer().setVisible(true);
    gvCoordinatePlane.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
  }

  @Override public void configureGraph(int minX, int maxX, int minY, int maxY, boolean isScaleX,
      boolean isScaleY) {
    gvCoordinatePlane.getViewport().setXAxisBoundsManual(true);
    gvCoordinatePlane.getViewport().setMinX(minX);
    gvCoordinatePlane.getViewport().setMaxX(maxX);

    gvCoordinatePlane.getViewport().setYAxisBoundsManual(true);
    gvCoordinatePlane.getViewport().setMinY(minY);
    gvCoordinatePlane.getViewport().setMaxY(maxY);

    gvCoordinatePlane.getViewport().setScalable(isScaleX);
    gvCoordinatePlane.getViewport().setScalableY(isScaleY);
  }

  @Override public void showToast(String sToastMessage) {
    Timber.wtf(sToastMessage);
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }
}
