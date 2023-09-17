package org.mi8qa.strikes.gutters.service.identity.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsConfigurationSource
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer


/**
 * CORS Configuration class.
 */
@Configuration
@EnableWebFlux
class CorsConfig : WebFluxConfigurer {


    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
//            .allowedOrigins("http://localhost:3000", "http://localhost:8080")
//            .allowedMethods("*")
//            .allowedHeaders("*")
//            .allowedOriginPatterns("*")
////            .allowCredentials(true)
//            .exposedHeaders("*")
//            .maxAge(3600)
    }

//    @Bean
//    fun corsFilter(): CorsWebFilter {
//        val source = UrlBasedCorsConfigurationSource()
//        val config = CorsConfiguration()
////        config.allowCredentials = true
//        config.addAllowedOrigin("http://localhost:8080/") // Allow all origins (you can restrict it to specific origins)
//        config.addAllowedOrigin("http://localhost:3000/") // Allow all origins (you can restrict it to specific origins)
//        config.addAllowedOrigin("http://localhost:8080") // Allow all origins (you can restrict it to specific origins)
//        config.addAllowedOrigin("http://localhost:3000") // Allow all origins (you can restrict it to specific origins)
//        config.addAllowedHeader("*")
//        config.addAllowedMethod("*")
//        config.exposedHeaders = listOf("*")
//        source.registerCorsConfiguration("/**", config)
//        return CorsWebFilter(source)
//    }
//
    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:3000", "http://localhost:8080","http://localhost:3000/", "http://localhost:8080/")
        configuration.allowedMethods = listOf("*")
        configuration.allowedHeaders = listOf("*")
        configuration.allowCredentials = true
        configuration.exposedHeaders = listOf("Access-Control-Allow-Origina")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}
