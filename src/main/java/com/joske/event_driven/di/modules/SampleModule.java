package com.joske.event_driven.di.modules;

import com.joske.event_driven.services.SamplesDynamoRepository;
import com.joske.event_driven.services.impl.SampleService;
import com.joske.event_driven.services.impl.TestSampleService;
import com.joske.event_driven.services.interfaces.ISampleService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class SampleModule {

    private final Scope scope;

    public SampleModule() {
        scope = Scope.valueOf(System.getenv("SCOPE"));
    }

    public SampleModule(Scope scope) {
        this.scope = scope;
    }

    @Provides
    @Singleton
    public ISampleService sampleService(SamplesDynamoRepository samplesDynamoRepository) {
        ISampleService sampleService = null;
        switch (this.scope) {
            case PROD:
                sampleService = new SampleService(samplesDynamoRepository);
                break;
            case TEST:
                sampleService = new TestSampleService();
                break;
        }
        return sampleService;
    }

    @Provides
    @Singleton
    public SamplesDynamoRepository samplesDynamoRepository() {
        return new SamplesDynamoRepository();
    }

    public enum Scope {
        TEST,
        PROD
    }
}
