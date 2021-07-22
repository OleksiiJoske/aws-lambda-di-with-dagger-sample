package com.joske.event_driven.services.impl;

import com.joske.event_driven.models.Event;
import com.joske.event_driven.models.EventRequest;
import com.joske.event_driven.services.SamplesDynamoRepository;
import com.joske.event_driven.services.interfaces.ISampleService;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class SampleService implements ISampleService {

    private final SamplesDynamoRepository samplesDynamoRepository;

    @Inject
    public SampleService(SamplesDynamoRepository samplesDynamoRepository) {
        this.samplesDynamoRepository = samplesDynamoRepository;
    }

    public Event handleRequest(EventRequest eventRequest) {
        return new Event(eventRequest.name, eventRequest.message + "-" + LocalDateTime.now());
    }
}
