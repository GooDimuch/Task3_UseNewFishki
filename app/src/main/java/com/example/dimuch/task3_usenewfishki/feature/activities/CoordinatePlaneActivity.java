package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.feature.presenters.CoordinatePlaneActivityPresenter;
import com.example.dimuch.task3_usenewfishki.feature.views.ICoordinatePlaneActivityView;
import timber.log.Timber;

public class CoordinatePlaneActivity extends MvpAppCompatActivity implements
    ICoordinatePlaneActivityView {

  @InjectPresenter CoordinatePlaneActivityPresenter coordinatePlaneActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coordinate_plane);
    ButterKnife.bind(this);
    
  }

  @Override public void showToast(String sToastMessage) {
    Timber.wtf(sToastMessage);
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }
}
