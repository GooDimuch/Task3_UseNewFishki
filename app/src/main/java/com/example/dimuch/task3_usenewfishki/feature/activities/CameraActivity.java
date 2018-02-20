package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.feature.presenters.CameraActivityPresenter;
import com.example.dimuch.task3_usenewfishki.feature.views.ICameraActivityView;
import com.squareup.picasso.Picasso;
import java.io.File;
import timber.log.Timber;

public class CameraActivity extends MvpAppCompatActivity implements ICameraActivityView {

  @BindView(R.id.bUsePhoto) Button bUsePhoto;
  @BindView(R.id.bUseVideo) Button bUseVideo;
  @BindView(R.id.ivPhoto) ImageView ivPhoto;

  @InjectPresenter CameraActivityPresenter cameraActivityPresenter;

  final int REQUEST_CODE_PHOTO = 1;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
    ButterKnife.bind(this);

    checkPermission();
  }

  private void checkPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA }, 1);
      }
    }
  }

  @OnClick(R.id.bUsePhoto) public void onClickUsePhoto() {
    showToast("onClickUsePhoto");
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraActivityPresenter.generateFileUri());
    startActivityForResult(intent, REQUEST_CODE_PHOTO);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if (resultCode == RESULT_OK) {
      Timber.wtf(cameraActivityPresenter.getPhoto().getPath());
      showPhoto(Uri.fromFile(cameraActivityPresenter.getPhoto()));
    } else if (resultCode == RESULT_CANCELED) {
      Timber.wtf("Canceled");
    }
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }

  @Override public void showPhoto(Uri uri) {
    Picasso.with(getApplicationContext()).load(uri)
        .fit()
        .placeholder(R.drawable.gd)
        .error(R.drawable.gd_red).into(ivPhoto);
  }

  @Override protected void onStart() {
    super.onStart();
    //Timber.wtf("onStart");
    SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    cameraActivityPresenter.setPhoto(new File(sharedPref.getString("FilePath", "null")));
  }

  @SuppressLint("ApplySharedPref") @Override protected void onPause() {
    super.onPause();
    //Timber.wtf("onPause");
    SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("FilePath", cameraActivityPresenter.getPhoto().getPath());
    editor.commit();
  }
}
