package com.joske.event_driven.di.modules;

import com.joske.event_driven.services.SamplesDynamoRepository;
import com.joske.event_driven.services.interfaces.ISampleService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SampleModule_SampleServiceFactory implements Factory<ISampleService> {
  private final SampleModule module;

  private final Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider;

  public SampleModule_SampleServiceFactory(
      SampleModule module, Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider) {
    this.module = module;
    this.samplesDynamoRepositoryProvider = samplesDynamoRepositoryProvider;
  }

  @Override
  public ISampleService get() {
    return provideInstance(module, samplesDynamoRepositoryProvider);
  }

  public static ISampleService provideInstance(
      SampleModule module, Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider) {
    return proxySampleService(module, samplesDynamoRepositoryProvider.get());
  }

  public static SampleModule_SampleServiceFactory create(
      SampleModule module, Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider) {
    return new SampleModule_SampleServiceFactory(module, samplesDynamoRepositoryProvider);
  }

  public static ISampleService proxySampleService(
      SampleModule instance, SamplesDynamoRepository samplesDynamoRepository) {
    return Preconditions.checkNotNull(
        instance.sampleService(samplesDynamoRepository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
