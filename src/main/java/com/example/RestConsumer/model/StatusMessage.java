package com.example.RestConsumer.model;

public class StatusMessage {

    private  String message;
    private  String status;

    public StatusMessage(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public StatusMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusMessage{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
