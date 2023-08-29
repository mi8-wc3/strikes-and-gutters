package org.mi8qa.strikes.gutters.service.identity.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

//todo this is for frontend only
@Configuration
@EnableWebFlux
class CorsConfig : WebFluxConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")  // in production you'd specify the actual frontend origin here
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .maxAge(3600)  // max time (in seconds) that the results of a preflight request can be cached
    }
}
