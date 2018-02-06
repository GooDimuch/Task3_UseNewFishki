package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.feature.presenters.MainActivityPresenter;
import com.example.dimuch.task3_usenewfishki.feature.views.IMainActivityView;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements IMainActivityView {

  @BindView(R.id.bCamera) Button bCamera;

  @InjectPresenter MainActivityPresenter mainActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @Override public void showToast(String sToastMessage) {
    Timber.e("showToast");
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }

  @OnClick(R.id.bCamera) public void onClickCamera(Button button) {
    //Intent intent = new Intent(this, CameraActivity.class);
    //startActivity(intent);
  }
}
