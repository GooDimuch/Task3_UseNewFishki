package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.feature.views.ICameraActivityView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import timber.log.Timber;

public class CameraActivity extends MvpAppCompatActivity implements ICameraActivityView {

  @BindView(R.id.bUsePhoto) Button bUsePhoto;
  @BindView(R.id.bUseVideo) Button bUseVideo;
  @BindView(R.id.ivPhoto) ImageView ivPhoto;

  File directory;
  File photo;
  final int REQUEST_CODE_PHOTO = 1;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
    ButterKnife.bind(this);

    createDirectory();
  }

  @OnClick(R.id.bUsePhoto) public void onClickUsePhoto() {
    showToast("onClickUsePhoto");
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    intent.putExtra(MediaStore.EXTRA_OUTPUT, generateFileUri());
    startActivityForResult(intent, REQUEST_CODE_PHOTO);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
     if (resultCode == RESULT_OK) {
       Timber.wtf(photo.getPath());
       Picasso.with(getApplicationContext())
           //.load(new File(directory.getPath() + "/" + "gd" + ".png"))
           .load(photo)
           .fit()
           .centerCrop()
           .placeholder(R.drawable.ic_launcher_background)
           .error(R.drawable.gd_red)
           .into(ivPhoto);
    } else if (resultCode == RESULT_CANCELED) {
      Timber.wtf("Canceled");
    }
  }

  private Uri generateFileUri() {
    photo = new File(directory.getPath() + "/" + getFileName() + ".jpg");
    return Uri.fromFile(photo);
  }

  private String getFileName() {
    @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter
        = new SimpleDateFormat ("yyyyMMddHHmmss");
    Date currentTime = Calendar.getInstance().getTime();
    return "photo_" + formatter.format(currentTime);
  }

  private void createDirectory() {
    directory =
        new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            "MyFolder");
    if (!directory.exists()) directory.mkdirs();
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }

  @Override protected void onStart() {
    super.onStart();
    Timber.wtf("onStart");
    SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    photo = new File(sharedPref.getString("FilePath", "null"));
  }

  @Override protected void onResume() {
    super.onResume();
    Timber.wtf("onResume");
  }

  @Override protected void onStop() {
    super.onStop();
    Timber.wtf("onStop");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    Timber.wtf("onDestroy");
  }

  @SuppressLint("ApplySharedPref") @Override protected void onPause() {
    super.onPause();
    Timber.wtf("onPause");
    SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("FilePath", photo.getPath());
    editor.commit();
  }
}
