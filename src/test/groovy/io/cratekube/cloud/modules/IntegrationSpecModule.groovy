package io.cratekube.cloud.modules

import com.google.inject.Provides
import io.cratekube.cloud.AppConfig
import io.dropwizard.client.JerseyClientBuilder
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule

import javax.inject.Singleton
import javax.ws.rs.client.Client

/**
 * Guice module used for integration specs.
 */
class IntegrationSpecModule extends DropwizardAwareModule<AppConfig> {
  @Provides
  @Singleton
  Client clientProvider() {
    return new JerseyClientBuilder(environment()).using(configuration().jerseyClient).build('external-client')
  }
}