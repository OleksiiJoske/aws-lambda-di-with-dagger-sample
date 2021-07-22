package com.joske.event_driven.di.modules;

import com.joske.event_driven.services.SamplesDynamoRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SampleModule_SamplesDynamoRepositoryFactory
    implements Factory<SamplesDynamoRepository> {
  private final SampleModule module;

  public SampleModule_SamplesDynamoRepositoryFactory(SampleModule module) {
    this.module = module;
  }

  @Override
  public SamplesDynamoRepository get() {
    return provideInstance(module);
  }

  public static SamplesDynamoRepository provideInstance(SampleModule module) {
    return proxySamplesDynamoRepository(module);
  }

  public static SampleModule_SamplesDynamoRepositoryFactory create(SampleModule module) {
    return new SampleModule_SamplesDynamoRepositoryFactory(module);
  }

  public static SamplesDynamoRepository proxySamplesDynamoRepository(SampleModule instance) {
    return Preconditions.checkNotNull(
        instance.samplesDynamoRepository(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
