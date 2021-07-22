package com.joske.event_driven.di.components;

import com.joske.event_driven.di.modules.SampleModule;
import com.joske.event_driven.di.modules.SampleModule_SampleServiceFactory;
import com.joske.event_driven.di.modules.SampleModule_SamplesDynamoRepositoryFactory;
import com.joske.event_driven.services.SamplesDynamoRepository;
import com.joske.event_driven.services.interfaces.ISampleService;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSampleComponent implements SampleComponent {
  private Provider<SamplesDynamoRepository> samplesDynamoRepositoryProvider;

  private Provider<ISampleService> sampleServiceProvider;

  private DaggerSampleComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static SampleComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.samplesDynamoRepositoryProvider =
        DoubleCheck.provider(
            SampleModule_SamplesDynamoRepositoryFactory.create(builder.sampleModule));
    this.sampleServiceProvider =
        DoubleCheck.provider(
            SampleModule_SampleServiceFactory.create(
                builder.sampleModule, samplesDynamoRepositoryProvider));
  }

  @Override
  public ISampleService sampleService() {
    return sampleServiceProvider.get();
  }

  public static final class Builder {
    private SampleModule sampleModule;

    private Builder() {}

    public SampleComponent build() {
      if (sampleModule == null) {
        this.sampleModule = new SampleModule();
      }
      return new DaggerSampleComponent(this);
    }

    public Builder sampleModule(SampleModule sampleModule) {
      this.sampleModule = Preconditions.checkNotNull(sampleModule);
      return this;
    }
  }
}
