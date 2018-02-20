package com.example.dimuch.task3_usenewfishki.feature.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.data.model.Message;
import com.example.dimuch.task3_usenewfishki.feature.adapters.ChatFirebaseAdapter;
import com.example.dimuch.task3_usenewfishki.feature.presenters.FirebaseActivityPresenter;
import com.example.dimuch.task3_usenewfishki.feature.views.IFirebaseActivityView;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/**
 * Created by Dimuch on 20.02.2018.
 */

public class FirebaseActivity extends MvpAppCompatActivity implements IFirebaseActivityView {

  @BindView(R.id.etMessage) EditText etMessage;
  @BindView(R.id.rvChatFirebase) RecyclerView rvChatFirebase;

  @InjectPresenter FirebaseActivityPresenter firebaseActivityPresenter;

  private final int SIGN_IN_REQUEST_CODE = 1;
  private List<Message> messageArray;
  private DatabaseReference firebaseRef;
  private ChatFirebaseAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_firebase);
    ButterKnife.bind(this);

    firebaseRef = FirebaseDatabase.getInstance().getReference().child("messages");
    firebaseRef.addChildEventListener(new ChildEventListener() {
      @Override public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Timber.wtf("onChildAdded");
        if (dataSnapshot != null && dataSnapshot.getValue() != null) {
          try {
            Message message = dataSnapshot.getValue(Message.class);
            messageArray.add(message);
            rvChatFirebase.scrollToPosition(messageArray.size() - 1);
            //adapter.notifyItemInserted(messageArray.size() - 1);
            adapter.notifyDataSetChanged();
          } catch (Exception e) {
            Timber.wtf("onChildAdded " + e.getMessage());
          }
        }
      }

      @Override public void onChildChanged(DataSnapshot dataSnapshot, String s) {

      }

      @Override public void onChildRemoved(DataSnapshot dataSnapshot) {

      }

      @Override public void onChildMoved(DataSnapshot dataSnapshot, String s) {

      }

      @Override public void onCancelled(DatabaseError databaseError) {
        Timber.wtf(databaseError.getMessage());
      }
    });
    checkAuthorization();
  }

  private List<Message> getMessageArray() {
    Timber.wtf("getMessageArray");
    messageArray = new ArrayList<>();
    firebaseRef.child("messages").addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        Timber.wtf("onDataChange");
        if (dataSnapshot != null && dataSnapshot.getValue() != null) {
          try {
            Message message = dataSnapshot.getValue(Message.class);
            messageArray.add(message);
            Timber.wtf("add(message)");
          } catch (Exception e) {
            Timber.wtf("onDataChange " + e.getMessage());
          }
        }
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
    return messageArray;
  }

  private void checkAuthorization() {
    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),
        SIGN_IN_REQUEST_CODE);
    //if (FirebaseAuth.getInstance().getCurrentUser() == null) {
    //  startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),
    //      SIGN_IN_REQUEST_CODE);
    //} else {
    //  displayChat();
    //}
  }

  private void displayChat() {
    messageArray = getMessageArray();
    rvChatFirebase.setLayoutManager(new LinearLayoutManager(this));
    adapter = new ChatFirebaseAdapter(messageArray);
    rvChatFirebase.setAdapter(adapter);
  }

  @OnClick(R.id.bSend) public void onClickSend() {
    if (!etMessage.getText().toString().isEmpty()) {
      firebaseRef.push()
          .setValue(new Message(etMessage.getText().toString(),
              FirebaseAuth.getInstance().getCurrentUser().getEmail()));
    }
    etMessage.setText("");
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == SIGN_IN_REQUEST_CODE)
    {
      if (resultCode == RESULT_OK)
      {
        showToast("Вход выполнен");
        displayChat();
      } else {
        showToast("Вход не выполнен");
        finish();
      }
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.menu_signout)
    {
      AuthUI.getInstance().signOut(this)
          .addOnCompleteListener(task -> {
            showToast("Выход выполнен");
            finish();
          });
    }
    return true;
  }

  @Override public void showToast(String sToastMessage) {
    Timber.wtf(sToastMessage);
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_LONG).show();
  }
}
