package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.os.Bundle;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.feature.presenters.FirebaseActivityPresenter;
import com.example.dimuch.task3_usenewfishki.feature.views.IFirebaseActivityView;

/**
 * Created by Dimuch on 20.02.2018.
 */

public class FirebaseActivity extends MvpAppCompatActivity implements IFirebaseActivityView {

  @InjectPresenter FirebaseActivityPresenter firebaseActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_firebase);
    ButterKnife.bind(this);
  }

  @Override public void showToast(String sToastMessage) {

  }
}
