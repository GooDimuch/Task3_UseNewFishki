package com.example.dimuch.task3_usenewfishki.feature.presenters;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Environment;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.task3_usenewfishki.App;
import com.example.dimuch.task3_usenewfishki.feature.views.ICameraActivityView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;

/**
 * Created by Dimuch on 06.02.2018.
 */

@InjectViewState public class CameraActivityPresenter extends MvpPresenter<ICameraActivityView> {

  //@Inject DataManager mDataManager;

  File directory;
  File photo;

  public CameraActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    createDirectory();
    getViewState().showPhoto(
        Uri.fromFile(new File(directory.getPath() + "/" + "photo_20180218191918" + ".jpg")));
  }

  private void createDirectory() {
    directory =
        new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            "MyFolder");
    if (!directory.exists()) directory.mkdirs();
  }

  public Uri generateFileUri() {
    photo = new File(directory.getPath() + "/" + getFileName() + ".jpg");
    return Uri.fromFile(photo);
  }

  private String getFileName() {
    @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter =
        new SimpleDateFormat("yyyyMMddHHmmss");
    Date currentTime = Calendar.getInstance().getTime();
    return "photo_" + formatter.format(currentTime);
  }

  public File getDirectory() {
    return directory;
  }

  public File getPhoto() {
    return photo;
  }

  public void setPhoto(File photo) {
    this.photo = photo;
  }
}
