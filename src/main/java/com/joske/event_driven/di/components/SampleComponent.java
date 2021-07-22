package com.joske.event_driven.di.components;

import com.joske.event_driven.di.modules.SampleModule;
import com.joske.event_driven.services.interfaces.ISampleService;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {SampleModule.class})
@Singleton
public interface SampleComponent {

    ISampleService sampleService();
}
