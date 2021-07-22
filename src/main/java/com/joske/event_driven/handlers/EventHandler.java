package com.joske.event_driven.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.joske.event_driven.di.components.DaggerSampleComponent;
import com.joske.event_driven.di.modules.SampleModule;
import com.joske.event_driven.models.Event;
import com.joske.event_driven.models.EventRequest;
import com.joske.event_driven.services.interfaces.ISampleService;

public class EventHandler implements RequestHandler<EventRequest, Event> {

    private final ISampleService sampleService;

    public EventHandler() {
        this.sampleService = DaggerSampleComponent.builder()
                .sampleModule(new SampleModule())
                .build()
                .sampleService();
    }

    public EventHandler(ISampleService sampleService) {
        this.sampleService = sampleService;
    }


    @Override
    public Event handleRequest(EventRequest eventRequest, Context context) {
        return sampleService.handleRequest(eventRequest);
    }
}
