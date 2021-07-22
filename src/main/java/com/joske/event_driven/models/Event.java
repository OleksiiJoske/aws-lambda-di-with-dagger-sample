package com.joske.event_driven.models;

public class Event {
    public String name;
    public String message;

    public Event() {
    }

    public Event(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
