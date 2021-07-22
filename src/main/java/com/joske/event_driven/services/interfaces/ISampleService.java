package com.joske.event_driven.services.interfaces;

import com.joske.event_driven.models.Event;
import com.joske.event_driven.models.EventRequest;

public interface ISampleService {
    Event handleRequest(EventRequest eventRequest);
}
