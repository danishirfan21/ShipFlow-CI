package com.shipflow;

public class MessageResponse {
    private String text;

    public MessageResponse() {}

    public MessageResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
