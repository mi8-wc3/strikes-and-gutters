package org.mi8qa.strikes.gutters.service.identity.configuration

import org.mi8qa.strikes.gutters.service.identity.service.CustomUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import java.security.SecureRandom


/**
 * Configuration class for WebFlux Security.
 */
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(useAuthorizationManager = true)
class SecurityConfig(
    private val customUserDetailsService: CustomUserDetailsService
) {


    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
//            .cors {it.disable()  }
            .csrf {  it.disable()}
            .authorizeExchange { exchanges ->
                exchanges
                    .anyExchange().authenticated()
            }
            .authenticationManager(UserDetailsRepositoryReactiveAuthenticationManager(customUserDetailsService))

            .formLogin { }
            .httpBasic { }
            .build()
    }



}
