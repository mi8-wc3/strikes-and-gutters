package org.mi8qa.strikes.gutters.service.identity.service

import UserRepository
import org.mi8qa.strikes.gutters.service.identity.entity.CustomUserDetails
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : ReactiveUserDetailsService {

    @Transactional(readOnly = true)
    override fun findByUsername(username: String): Mono<UserDetails> {
        return userRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(UsernameNotFoundException("User not found")))
                .map { customUserDetails ->
                    User.withUsername(customUserDetails.username)
                        .password("{bcrypt}" + customUserDetails.password)
                        .authorities(customUserDetails.authorities)
                        .build()
                } ?: Mono.error(UsernameNotFoundException("User Repository not found"))
    }
}
