package org.mi8qa.strikes.gutters.service.identity.configuration

import org.mi8qa.strikes.gutters.service.identity.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(useAuthorizationManager = true)
class IdentityServiceConfig {

    @Autowired
        private val userRepository: UserRepository? = null

    @Bean
    open fun springWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.authorizeExchange {
            it.anyExchange().permitAll()
        }
            .httpBasic {}
            .build()
    }

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService {
        val userBuilder: User.UserBuilder = User.withDefaultPasswordEncoder()
//        val rob = userBuilder.username("user")
//            .password("user")
//            .roles("USER")
//            .build()
        val admin = userBuilder.username("admin")
            .password("admin")
            .roles("USER", "ADMIN")
            .build()
        return MapReactiveUserDetailsService(admin)
    }

}
