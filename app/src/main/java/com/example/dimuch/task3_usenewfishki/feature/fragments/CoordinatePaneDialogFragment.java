package com.example.dimuch.task3_usenewfishki.feature.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.dimuch.task3_usenewfishki.R;
import timber.log.Timber;

public class CoordinatePaneDialogFragment extends DialogFragment {

  @BindView(R.id.etX) EditText etX;
  @BindView(R.id.etY) EditText etY;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.dialog_coordinate_pane, null);
    ButterKnife.bind(this, view);

    return view;
  }

  public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);
    Timber.wtf("Dialog: onDismiss");
  }

  public void onCancel(DialogInterface dialog) {
    super.onCancel(dialog);
    Timber.wtf("Dialog: onCancel");
  }

  @OnClick(R.id.bAddPoint) public void onClickAddPoint() {
    Timber.wtf("onClickAddPoint");
  }
}