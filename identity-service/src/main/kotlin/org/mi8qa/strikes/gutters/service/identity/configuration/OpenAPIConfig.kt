package org.mi8qa.strikes.gutters.service.identity.configuration

import org.springdoc.core.models.GroupedOpenApi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenAPIConfig {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("public-api")
            .pathsToMatch("/public/**")
            .build()
    }

    @Bean
    fun privateApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("private-api")
            .packagesToScan("org.mi8qa")
            .build()
    }
}
