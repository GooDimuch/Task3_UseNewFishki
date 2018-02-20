package com.example.dimuch.task3_usenewfishki.data.model;

import java.util.Date;

public class Message {

  private String textMessage;
  private String nameAuthor;
  private long timeMessage;

  public Message(String textMessage, String nameAuthor) {
    this.textMessage = textMessage;
    this.nameAuthor = nameAuthor;

    timeMessage = new Date().getTime();
  }

  public Message() {
  }

  public String getTextMessage() {
    return textMessage;
  }

  public void setTextMessage(String textMessage) {
    this.textMessage = textMessage;
  }

  public String getNameAuthor() {
    return nameAuthor;
  }

  public void setNameAuthor(String nameAuthor) {
    this.nameAuthor = nameAuthor;
  }

  public long getTimeMessage() {
    return timeMessage;
  }

  public void setTimeMessage(long timeMessage) {
    this.timeMessage = timeMessage;
  }
}