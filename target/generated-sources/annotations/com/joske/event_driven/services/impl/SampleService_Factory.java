package com.joske.event_driven.services.impl;

import com.joske.event_driven.services.SamplesDynamoRepository;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SampleService_Factory implements Factory<SampleService> {
  private final Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider;

  public SampleService_Factory(Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider) {
    this.samplesDynamoRepositoryProvider = samplesDynamoRepositoryProvider;
  }

  @Override
  public SampleService get() {
    return provideInstance(samplesDynamoRepositoryProvider);
  }

  public static SampleService provideInstance(
      Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider) {
    return new SampleService(samplesDynamoRepositoryProvider.get());
  }

  public static SampleService_Factory create(
      Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider) {
    return new SampleService_Factory(samplesDynamoRepositoryProvider);
  }

  public static SampleService newSampleService(SamplesDynamoRepository samplesDynamoRepository) {
    return new SampleService(samplesDynamoRepository);
  }
}
