package com.example.dimuch.task3_usenewfishki.feature.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.dimuch.task3_usenewfishki.R;
import com.example.dimuch.task3_usenewfishki.data.model.Message;
import java.util.List;

public class ChatFirebaseAdapter extends RecyclerView.Adapter<ChatFirebaseAdapter.ViewHolder> {

  private List<Message> messageArray;

  public ChatFirebaseAdapter(List<Message> messageArray) {
    this.messageArray = messageArray;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message, parent, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Message message = messageArray.get(position);

    holder.tvNameAuthor.setText(message.getNameAuthor());
    holder.tvTextMessage.setText(message.getTextMessage());
    holder.tvTimeMessage.setText(DateFormat.format("HH:mm", message.getTimeMessage()));
  }

  @Override public int getItemCount() {
    return messageArray == null ? 0 : messageArray.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvNameAuthor) TextView tvNameAuthor;
    @BindView(R.id.tvTextMessage) TextView tvTextMessage;
    @BindView(R.id.tvTimeMessage) TextView tvTimeMessage;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}