package com.joske.event_driven.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.joske.event_driven.di.components.DaggerSampleComponent;
import com.joske.event_driven.di.modules.SampleModule;
import com.joske.event_driven.models.EventRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EventHandlerTest {

    private Context contextMock;
    private EventHandler handler;


    @BeforeAll
    public void setUp() {
        contextMock = new TestContext();
        handler = new EventHandler(DaggerSampleComponent.builder()
                .sampleModule(new SampleModule(SampleModule.Scope.TEST))
                .build()
                .sampleService()
        );
    }

    @Test
    public void test_handleRequest() {
        // Given
        var event = new EventRequest("hi", "joske");

        // When
        var response = handler.handleRequest(event, contextMock);

        // Then
        Assertions.assertNotNull(response);
        Assertions.assertEquals("test", response.message
        );
    }
}
