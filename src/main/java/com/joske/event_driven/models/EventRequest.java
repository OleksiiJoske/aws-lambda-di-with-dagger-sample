package com.joske.event_driven.models;

public class EventRequest {
    public String name;
    public String message;

    public EventRequest() {
    }

    public EventRequest(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
