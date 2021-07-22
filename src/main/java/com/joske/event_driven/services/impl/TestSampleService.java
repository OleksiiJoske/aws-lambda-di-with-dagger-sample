package com.joske.event_driven.services.impl;

import com.joske.event_driven.models.Event;
import com.joske.event_driven.models.EventRequest;
import com.joske.event_driven.services.interfaces.ISampleService;

import javax.inject.Singleton;

@Singleton
public class TestSampleService implements ISampleService {
    @Override
    public Event handleRequest(EventRequest eventRequest) {
        return new Event("test", "test");
    }
}
